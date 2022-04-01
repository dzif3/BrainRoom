package com.example.brainroom.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.MainActivity;
import com.example.brainroom.R;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button parent = findViewById(R.id.signupparent);
        Button student = findViewById(R.id.signupstudent);
        ImageView login = findViewById(R.id.btn_sign_in);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignUpStep2.class);
                startActivity(intent);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignUpStep2.class);
                startActivity(intent);
            }
        });
    }
}
