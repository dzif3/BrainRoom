package com.example.brainroom.splashscree;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.Login.LogIn;
import com.example.brainroom.R;

public class SplashScreen extends AppCompatActivity {

        private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, LogIn.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
