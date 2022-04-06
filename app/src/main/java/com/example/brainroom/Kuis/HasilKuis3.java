package com.example.brainroom.Kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.brainroom.R;

public class HasilKuis3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis3);
        TextView hasil = (TextView) findViewById(R.id.hasil3);
        TextView nilai = (TextView) findViewById(R.id.nilai3);

        hasil.setText("Jawaban Benar :" + KuisIndo.benar3 + "\nJawaban Salah :" + KuisIndo.salah3);
        nilai.setText("" + KuisIndo.hasil3);
    }

    public void ulangi(View view) {
        finish();
        Intent a = new Intent(getApplicationContext(), KuisIndo.class);
        startActivity(a);
    }
}