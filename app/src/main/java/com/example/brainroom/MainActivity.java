package com.example.brainroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brainroom.Kuis.KuisFisika;
import com.example.brainroom.Kuis.KuisInggris;
import com.example.brainroom.Kuis.KuisMatematika;
import com.example.brainroom.Mapel.activity.BahasaIndonesia;
import com.example.brainroom.Mapel.activity.BahasaInggris;
import com.example.brainroom.Mapel.activity.Biologi;
import com.example.brainroom.Mapel.activity.Fisika;
import com.example.brainroom.Mapel.activity.Kimia;
import com.example.brainroom.Mapel.activity.Matematika;
import com.example.brainroom.R;
import com.example.brainroom.profile.EditProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Profile
        ImageView setting = findViewById(R.id.buttonsetting);
        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });
        //mapel
        ImageView mtka = findViewById(R.id.button_matematika);
        ImageView indo = findViewById(R.id.button_indonesia);
        ImageView eng = findViewById(R.id.button_english);
        ImageView kim = findViewById(R.id.button_kimia);
        ImageView fis = findViewById(R.id.button_fisika);
        ImageView bio = findViewById(R.id.button_biologi);

        kim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Kimia.class);
                startActivity(intent);
            }
        });
        fis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Fisika.class);
                startActivity(intent);
            }
        });
        bio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Biologi.class);
                startActivity(intent);
            }
        });
        mtka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Matematika.class);
                startActivity(intent);
            }
        });
        indo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BahasaIndonesia.class);
                startActivity(intent);
            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BahasaInggris.class);
                startActivity(intent);
            }
        });

        //kuis
        ImageView kuis = findViewById(R.id.kuismtk);
        ImageView kuis1 = findViewById(R.id.kuisbing);
        ImageView kuis2 = findViewById(R.id.kuisfisika);

        kuis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisMatematika.class);
                startActivity(intent);
            }
        });
        kuis1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisInggris.class);
                startActivity(intent);
            }
        });
        kuis2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisFisika.class);
                startActivity(intent);
            }
        });


    }
}