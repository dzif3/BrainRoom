package com.example.brainroom.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.R;

public class SignUpStep2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secure_account);

        Button backsignup2 = findViewById(R.id.backsignup2);
        Button nextsignup2 = findViewById(R.id.nextsignup2);

        backsignup2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUpStep2.this, SignUp.class);
                startActivity(intent);
            }
        });

        nextsignup2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUpStep2.this, SignUpStep3.class);
                startActivity(intent);
            }
        });
    }
}
