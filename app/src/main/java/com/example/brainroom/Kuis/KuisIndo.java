package com.example.brainroom.Kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainroom.R;

public class KuisIndo extends AppCompatActivity {

    TextView kuis3;
    RadioGroup rg3;
    RadioButton PilihanA3, PilihanB3, PilihanC3, PilihanD3;
    int nomor3 = 0;
    public static int hasil3, benar3, salah3;

    //pertanyaan
    String[] pertanyaan_kuis_indo = new String[]{
            "1. A : what do you have?\n" +
                    "\n" +
                    "B : I______a cup of coffee",
            "2. ________open the door please?",
            "3. ________you make me a birthday cake?",
            "4. _______you have a new house?",
            "5. I have seven marbles, Diana has three marbles, we have_____"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban_indo = new String[]{
            "have", "has", "can", "may",
            "is", "are", "could", "was",
            "is", "can", "are", "have",
            "are", "is", "does", "do",
            "twenty marbles", "Ten Marbles", "fifteen marbles", "twenty one marbles"
    };

    //jawaban benar
    String[] jawaban_benar_indo = new String[]{
            "have",
            "could",
            "can",
            "do",
            "Ten Marbles"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuis_indo);

        kuis3 = (TextView) findViewById(R.id.kuis2);
        rg3 = (RadioGroup) findViewById(R.id.pilihan2);
        PilihanA3 = (RadioButton) findViewById(R.id.pilihanA2);
        PilihanB3 = (RadioButton) findViewById(R.id.pilihanB2);
        PilihanC3 = (RadioButton) findViewById(R.id.pilihanC2);
        PilihanD3 = (RadioButton) findViewById(R.id.pilihanD2);

        kuis3.setText(pertanyaan_kuis_indo[nomor3]);
        PilihanA3.setText(pilihan_jawaban_indo[0]);
        PilihanB3.setText(pilihan_jawaban_indo[1]);
        PilihanC3.setText(pilihan_jawaban_indo[2]);
        PilihanD3.setText(pilihan_jawaban_indo[3]);

        rg3.check(0);
        benar3 = 0;
        salah3 = 0;
    }

    public void next(View view) {
        if (PilihanA3.isChecked() || PilihanB3.isChecked() || PilihanC3.isChecked() || PilihanD3.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg3.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg3.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar_indo[nomor3])) benar3++;
            else salah3++;
            nomor3++;
            if (nomor3 < pertanyaan_kuis_indo.length) {
                kuis3.setText(pertanyaan_kuis_indo[nomor3]);
                PilihanA3.setText(pilihan_jawaban_indo[(nomor3 * 4) + 0]);
                PilihanB3.setText(pilihan_jawaban_indo[(nomor3 * 4) + 1]);
                PilihanC3.setText(pilihan_jawaban_indo[(nomor3 * 4) + 2]);
                PilihanD3.setText(pilihan_jawaban_indo[(nomor3 * 4) + 3]);

            } else {
                hasil3 = benar3 * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Silahkan Pilih jawaban diatas",Toast.LENGTH_LONG).show();
        }
    }
}