package com.example.contact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.contact.controller.ContactService;
import com.example.contact.entities.Contact;
import com.example.contact.enums.SIM;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddEditContact extends AppCompatActivity {

    private ImageView profile;
    private EditText prenomEdit, nomEdit, teleEdit, emailEdit;
    RadioGroup radioSIM;
    private FloatingActionButton fabBtn;
    private String url = "http://192.168.244.81:8082/";
    Long id;
    //String variable;
    private String image, prenom, nom, tele,email;
    SIM sim;
    private Boolean isEditMode;

    //action bar
    private ActionBar actionBar;

    //permission constant
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 200;
    private static final int IMAGE_FROM_GALLERY_CODE = 300;
    private static final int IMAGE_FROM_CAMERA_CODE = 400;

    // string array of permission
    private String[] cameraPermission;
    private String[] storagePermission;

    //Image uri var
    private Uri imageUri;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_contact);


        //init permission
        cameraPermission = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        //init actionBar
        actionBar = getSupportActionBar();

        //back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init view
        profile = findViewById(R.id.profile);
        prenomEdit = findViewById(R.id.prenom);
        nomEdit = findViewById(R.id.nom);
        teleEdit = findViewById(R.id.teleForm);
        emailEdit = findViewById(R.id.emailForm);
        radioSIM = findViewById(R.id.radio_SIM);
        fabBtn = findViewById(R.id.fab);

        // get intent data
        Intent intent = getIntent();
        isEditMode = intent.getBooleanExtra("isEditMode",false);

        radioSIM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.radio_SIM1:
                        sim =SIM.SIM_1;
                        // MALE radio button is checked
                        break;
                    case R.id.radio_SIM2:
                        sim =SIM.SIM_2;
                        // FEMALE radio button is checked
                        break;
                }
            }
        });
        if (isEditMode){
            //set toolbar title
            actionBar.setTitle("Update Contact");

            //get the other value from intent
            id = intent.getLongExtra("ID",0);
            prenom = intent.getStringExtra("PRENOM");
            nom = intent.getStringExtra("NOM");
            tele = intent.getStringExtra("TELE");
            email = intent.getStringExtra("EMAIL");
            sim = (Objects.equals(intent.getStringExtra("SIM"), "1"))?SIM.SIM_1:SIM.SIM_2;
            image = "";

            //set value in editText field
            prenomEdit.setText(prenom);
            teleEdit.setText(tele);
            emailEdit.setText(email);
            nomEdit.setText(nom);
            imageUri = Uri.parse(image);

            if (image.equals("")){
                profile.setImageResource(R.drawable.ic_baseline_person_24);
            }else {
                profile.setImageURI(imageUri);
            }

        }else {
            // add mode on
            actionBar.setTitle("Add Contact");
        }

        // add even handler
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagePickerDialog();
            }
        });
    }

    private void showImagePickerDialog() {

        //option for dialog
        String options[] = {"Camera","Gallery"};

        // Alert dialog builder
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);

        //setTitle
        builder.setTitle("Choose An Option");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //handle item click
                if (which == 0){ //start from 0 index
                    //camera selected
                    if (!checkCameraPermission()){
                        //request camera permission
                        requestCameraPermission();
                    }else {
                        pickFromCamera();
                    }
                        
                }else if (which == 1){
                    //Gallery selected
                    if (!checkStoragePermission()){
                        //request storage permission
                        requestStoragePermission();
                    }else {
                        pickFromGallery();
                    }
                    
                }
            }
        }).create().show();
    }

    private void pickFromGallery() {
        //intent for taking image from gallery
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*"); // only Image

        startActivityForResult(galleryIntent,IMAGE_FROM_GALLERY_CODE);
    }

    private void pickFromCamera() {

//       ContentValues for image info
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"IMAGE_TITLE");
        values.put(MediaStore.Images.Media.DESCRIPTION,"IMAGE_DETAIL");

        //save imageUri
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);

        //intent to open camera
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);

        startActivityForResult(cameraIntent,IMAGE_FROM_CAMERA_CODE);
    }


    private void saveData() {

        //take user giver data in variable
        prenom = prenomEdit.getText().toString();
        tele = teleEdit.getText().toString();
        email = emailEdit.getText().toString();
        nom = nomEdit.getText().toString();

        // get current time to save as added time


        //check filed data
        if (!prenom.isEmpty() || !tele.isEmpty() || !email.isEmpty() || !nom.isEmpty()){
            //save data ,if user have only one data
            Retrofit retrofit = new Retrofit.Builder( ).baseUrl(url).addConverterFactory(GsonConverterFactory.create( )).build( );
            ContactService api = retrofit.create(ContactService.class);
            Contact c=new Contact(0, prenom, nom,email, tele, sim);

            //check edit or add mode to save data in sql
            if (isEditMode){
                // edit mode
                api.updateContact(id,c).enqueue(new Callback<Contact>() {
                    @Override
                    public void onResponse(Call<Contact> call, Response<Contact> response) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("data_updated", true);
                        setResult(Activity.RESULT_OK, resultIntent);

                        Toast.makeText(getApplicationContext(), "Updated Successfully.... "+id, Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Contact> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error.... "+id, Toast.LENGTH_SHORT).show();

                    }
                });

            }else {
               api.addContact(c).enqueue(new Callback<Contact>() {
                   @Override
                   public void onResponse(Call<Contact> call, Response<Contact> response) {
                       Intent resultIntent = new Intent();
                       resultIntent.putExtra("data_updated", true);
                       setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                        Toast.makeText(getApplicationContext(), "Inserted Successfully.... "+id, Toast.LENGTH_SHORT).show();

                   }

                   @Override
                   public void onFailure(Call<Contact> call, Throwable t) {
                       Toast.makeText(getApplicationContext(), "Error.... "+id, Toast.LENGTH_SHORT).show();

                   }
               });
                //To check insert data successfully ,show a toast message
                }

        }else {
            // show toast message
            Toast.makeText(getApplicationContext(), "Nothing to save....", Toast.LENGTH_SHORT).show();
        }

    }

    //ctr + O

    //back button click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    //check camera permission
    private boolean checkCameraPermission(){
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);

        return result & result1;
    }

    //request for camera permission
    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(this,cameraPermission,CAMERA_PERMISSION_CODE); // handle request permission on override method
    }

    //check storage permission
    private boolean checkStoragePermission(){
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);

        return result1;
    }

    //request for camera permission
    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(this,storagePermission,STORAGE_PERMISSION_CODE);
    }


    //handle request permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case CAMERA_PERMISSION_CODE:
                if (grantResults.length >0){

                    //if all permission allowed return true , otherwise false
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (cameraAccepted && storageAccepted){
                        //both permission granted
                        pickFromCamera();
                    }else {
                        //permission not granted
                        Toast.makeText(getApplicationContext(), "Camera & Storage Permission needed..", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case STORAGE_PERMISSION_CODE:
                if (grantResults.length >0){

                    //if all permission allowed return true , otherwise false
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (storageAccepted){
                        //permission granted
                        pickFromGallery();
                    }else {
                        //permission not granted
                        Toast.makeText(getApplicationContext(), "Storage Permission needed..", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == IMAGE_FROM_GALLERY_CODE){
                // picked image from gallery
                //crop image
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1,1)
                        .start(AddEditContact.this);

            }else if (requestCode == IMAGE_FROM_CAMERA_CODE){
                //picked image from camera
                //crop Image
                CropImage.activity(imageUri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1,1)
                        .start(AddEditContact.this);
            }else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

                //cropped image received
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                imageUri = result.getUri();
                profile.setImageURI(imageUri);

            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                //for error handling
                Toast.makeText(getApplicationContext(), "Something wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

}