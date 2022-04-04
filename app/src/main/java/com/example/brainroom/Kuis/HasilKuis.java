package com.example.brainroom.Kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.brainroom.MainActivity;
import com.example.brainroom.R;

public class HasilKuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis);

        Button kuis = (Button) findViewById(R.id.ulang);
        kuis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HasilKuis.this, KuisFisika.class);
                startActivity(intent);
            }
        });

        Button kuis1 = (Button) findViewById(R.id.kembali);
        kuis1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HasilKuis.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar :"+KuisFisika.benar+"\nJawaban Salah :"+KuisFisika.salah);
        nilai.setText(""+KuisFisika.hasil);

    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),KuisFisika.class);
        startActivity(a); 
    }
}