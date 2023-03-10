package ma.enset.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String name=getIntent().getStringExtra("nom");
        String pass=getIntent().getStringExtra("password");

        EditText NomUtilisateur=findViewById(R.id.editText_NomUtilisateur2);
        EditText MotDePasse=findViewById(R.id.editText_MotDePasse2);
        /*
        Bundle b = getIntent().getExtras();
        String name = b.getString("nom");
         */
        NomUtilisateur.setText(name);
        MotDePasse.setText(pass);

    }
    public void retour(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}