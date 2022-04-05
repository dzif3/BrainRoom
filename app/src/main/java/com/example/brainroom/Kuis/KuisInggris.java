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

public class KuisInggris extends AppCompatActivity {

    TextView kuis2;
    RadioGroup rg2;
    RadioButton PilihanA2, PilihanB2, PilihanC2, PilihanD2;
    int nomor2 = 0;
    public static int hasil2, benar2, salah2;

    //pertanyaan
    String[] pertanyaan_kuis_inggris = new String[]{
            "1. A : what do you have?\n" +
                    "\n" +
                    "B : I______a cup of coffee",
            "2. ________open the door please?",
            "3. ________you make me a birthday cake?",
            "4. _______you have a new house?",
            "5. I have seven marbles, Diana has three marbles, we have_____"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban_inggris = new String[]{
            "have", "has", "can", "may",
            "is", "are", "could", "was",
            "is", "can", "are", "have",
            "are", "is", "does", "do",
            "twenty marbles", "Ten Marbles", "fifteen marbles", "twenty one marbles"
    };

    //jawaban benar
    String[] jawaban_benar_inggris = new String[]{
            "have",
            "could",
            "can",
            "do",
            "Ten Marbles"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuis_inggris);

        kuis2 = (TextView) findViewById(R.id.kuis2);
        rg2 = (RadioGroup) findViewById(R.id.pilihan2);
        PilihanA2 = (RadioButton) findViewById(R.id.pilihanA2);
        PilihanB2 = (RadioButton) findViewById(R.id.pilihanB2);
        PilihanC2 = (RadioButton) findViewById(R.id.pilihanC2);
        PilihanD2 = (RadioButton) findViewById(R.id.pilihanD2);

        kuis2.setText(pertanyaan_kuis_inggris[nomor2]);
        PilihanA2.setText(pilihan_jawaban_inggris[0]);
        PilihanB2.setText(pilihan_jawaban_inggris[1]);
        PilihanC2.setText(pilihan_jawaban_inggris[2]);
        PilihanD2.setText(pilihan_jawaban_inggris[3]);

        rg2.check(0);
        benar2 = 0;
        salah2 = 0;
    }

    public void next(View view) {
        if (PilihanA2.isChecked() || PilihanB2.isChecked() || PilihanC2.isChecked() || PilihanD2.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg2.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar_inggris[nomor2])) benar2++;
            else salah2++;
            nomor2++;
            if (nomor2 < pertanyaan_kuis_inggris.length) {
                kuis2.setText(pertanyaan_kuis_inggris[nomor2]);
                PilihanA2.setText(pilihan_jawaban_inggris[(nomor2 * 4) + 0]);
                PilihanB2.setText(pilihan_jawaban_inggris[(nomor2 * 4) + 1]);
                PilihanC2.setText(pilihan_jawaban_inggris[(nomor2 * 4) + 2]);
                PilihanD2.setText(pilihan_jawaban_inggris[(nomor2 * 4) + 3]);

            } else {
                hasil2 = benar2 * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        } else {
            Toast.makeText(this, "Silahkan Pilih jawaban diatas", Toast.LENGTH_LONG).show();
        }
    }
}