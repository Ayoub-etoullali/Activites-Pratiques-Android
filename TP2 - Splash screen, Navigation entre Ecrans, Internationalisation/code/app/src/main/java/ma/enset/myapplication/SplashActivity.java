package ma.enset.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(SplashActivity.this,
                    MainActivity.class);
            startActivity(i);
            // close this activity
            finish();
        }, SPLASH_TIME_OUT);

    }
}
