package com.example.brainroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.brainroom.Mapel.activity.BahasaIndonesia;
import com.example.brainroom.Mapel.activity.Matematika;

public class tester extends AppCompatActivity {
    private Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        button = findViewById(R.id.bidn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tester.this, BahasaIndonesia.class);
                startActivity(intent);
            }
        });
        button1 = findViewById(R.id.mtk);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tester.this, Matematika.class);
                startActivity(intent);
            }
        });
    }
}