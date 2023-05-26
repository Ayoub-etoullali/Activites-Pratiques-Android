package com.example.etoullali;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.etoullali.*;


public class login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Toast.makeText(this, "OnCreate called", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "OnStart called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "OnResume called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "OnPause called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "OnStop called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "OnDestroy called", Toast.LENGTH_SHORT).show();
    }

    public void envoyer(View view) {
        EditText Name = findViewById(R.id.editText_NomUtilisateur1);
        EditText Pass = findViewById(R.id.editText_MotDePasse1);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nom", Name.getText().toString());
        intent.putExtra("password", Pass.getText().toString());
        /*
        Bundle b = new Bundle();
        b.putString("nom", Name.getText().toString());
        b.putString("password", Pass.getText().toString());
        intent.putExtras(b);
         */
        startActivity(intent);
    }
}