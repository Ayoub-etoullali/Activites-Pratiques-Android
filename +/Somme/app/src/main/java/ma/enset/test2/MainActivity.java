package ma.enset.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private EditText editTextResultat;
    private Button button_Somme;
    private Button button_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextResultat = findViewById(R.id.editTextResultat);
        button_Somme = findViewById(R.id.button_Somme);
        button_Reset = findViewById(R.id.button_Reset);

        /*
        button_Somme.setOnClickListener((evt)->{
            int res=Integer.parseInt(editTextNumber1.getText().toString()+editTextNumber2.getText().toString());
            textView_Resultat.setText(res);
        });
         */
        button_Somme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(editTextNumber1.getText().toString());
                int num2 = Integer.parseInt(editTextNumber2.getText().toString());
                int res = num1 + num2;
                editTextResultat.setText(String.valueOf(res));
            }
        });

        button_Reset.setOnClickListener((a)-> {
                editTextNumber1.setText("");
                editTextNumber2.setText("");
                editTextResultat.setText("");
        });
    }
}