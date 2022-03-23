package com.example.brainroom.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.MainActivity;
import com.example.brainroom.R;

public class SignUpStep3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_profile);

        Button finish = findViewById(R.id.finishsignupstep3);
        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SignUpStep3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
