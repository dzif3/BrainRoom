package com.example.brainroom.kisisoal.Hasil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.brainroom.R;
import com.example.brainroom.kisisoal.KisMTK;
import com.example.brainroom.kisisoal.soal.SoalMtkSatu;

public class HasilMatematika extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kisi_hasil_matematika);


        Button kuis = findViewById(R.id.ulang);
        Button kuis1 = findViewById(R.id.kembali);
        TextView hasil = findViewById(R.id.hasilmtk);
        TextView nilai = findViewById(R.id.nilaimtk);


        kuis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HasilMatematika.this, SoalMtkSatu.class);
                startActivity(intent);
            }
        });
        kuis1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HasilMatematika.this, KisMTK.class);
                startActivity(intent);
            }
        });

        hasil.setText("Jawaban Benar :"+SoalMtkSatu.benar+"\nJawaban Salah :"+SoalMtkSatu.salah);
        nilai.setText(""+SoalMtkSatu.hasil);

    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),SoalMtkSatu.class);
        startActivity(a);
    }
}