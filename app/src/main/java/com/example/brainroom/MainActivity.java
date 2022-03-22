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
import com.example.brainroom.Mapel.activity.Matematika;
import com.example.brainroom.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView mtk = (ImageView) findViewById(R.id.button_matematika);
        mtk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Matematika.class);
                startActivity(intent);
            }
        });
        ImageView indo = (ImageView) findViewById(R.id.button_indonesia);
        indo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BahasaIndonesia.class);
                startActivity(intent);
            }
        });
        ImageView eng = (ImageView) findViewById(R.id.button_english);
        eng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BahasaInggris.class);
                startActivity(intent);
            }
        });
// atas mapel bawah kuis
        ImageView kuis = (ImageView) findViewById(R.id.kuismtk);
        kuis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisMatematika.class);
                startActivity(intent);
            }
        });

        ImageView kuis1 = (ImageView) findViewById(R.id.kuisbing);
        kuis1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisInggris.class);
                startActivity(intent);
            }
        });

        ImageView kuis2 = (ImageView) findViewById(R.id.kuisfisika);
        kuis2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KuisFisika.class);
                startActivity(intent);
            }
        });


    }
}