package com.example.brainroom.Kuis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainroom.R;

public class KuisFisika extends AppCompatActivity {
    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Dari contoh soal pertama, bila lantai kondisinya menjadi licin atau koefisien gaya gesek dihilangkan (μ=0), berapa percepatan objeknya?",
            "2. Sebuah box berada di atas permukaan datar berkoefisien gesek statis 0,3 serta gesek kinetis 0,1. Apabila massa box sebesar 15 kg, kemudian ditarik dengan gaya sebesar 60 N, berapa gaya gesek box terhadap permukaan dan percepatannya?",
            "3. Berdasarkan contoh soal kelima, jika gayanya diperkecil menjadi 30N, berapa besar gaya geseknya saat ini?",
            "4. Hitunglah kembali contoh soal ketujuh jika koefisien gaya gesek kedua box menjadi 0,1.",
            "5. Berdasarkan contoh soal kesembilan, jika massa box diperkecil menjadi A = 20 kg dan B = 5 kg sementara gaya F juga diperkecil menjadi 250 N, berapa gaya kontaknya saat ini?"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "5 m/s2", "10 m/s2", "2 m/s2", "8 m/s2",
            "13 m/s2", "10 N", "45 N & 3 m/s2", "19 N",
            "17 N", "5 N", "40 N", "30 N",
            "20 N", "30 N", "10 N", "40 N",
            "50 N", "11 m/s2", "8 m/s2", "10 N"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "5 m/s2",
            "45 N & 3 m/s2",
            "30 N",
            "30 N",
            "50 N"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuis_fisika);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        } else {
            Toast.makeText(this, "Silahkan Pilih jawaban diatas", Toast.LENGTH_LONG).show();
        }
    }
}

