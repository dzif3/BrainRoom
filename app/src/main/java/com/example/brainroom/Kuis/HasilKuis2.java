package com.example.brainroom.Kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.brainroom.R;

public class HasilKuis2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis2);
        TextView hasil = (TextView)findViewById(R.id.hasil2);
        TextView nilai = (TextView)findViewById(R.id.nilai2);

        hasil.setText("Jawaban Benar :"+KuisInggris.benar2+"\nJawaban Salah :"+KuisInggris.salah2);
        nilai.setText(""+KuisInggris.hasil2);
    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),KuisInggris.class);
        startActivity(a);
    }
}