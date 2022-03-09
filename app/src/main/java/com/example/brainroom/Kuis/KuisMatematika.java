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

public class KuisMatematika extends AppCompatActivity {

    TextView kuis1;
    RadioGroup rg1;
    RadioButton PilihanA1, PilihanB1, PilihanC1, PilihanD1;
    int nomor1 = 0;
    public static int hasil1, benar1, salah1;

    String[] pertanyaan_kuis_mtk = new String[]{
            "1. Dari contoh soal pertama, bila lantai kondisinya menjadi licin atau koefisien gaya gesek dihilangkan (μ=0), berapa percepatan objeknya?",
            "2. Sebuah box berada di atas permukaan datar berkoefisien gesek statis 0,3 serta gesek kinetis 0,1. Apabila massa box sebesar 15 kg, kemudian ditarik dengan gaya sebesar 60 N, berapa gaya gesek box terhadap permukaan dan percepatannya?",
            "3. Berdasarkan contoh soal kelima, jika gayanya diperkecil menjadi 30N, berapa besar gaya geseknya saat ini?",
            "4. Hitunglah kembali contoh soal ketujuh jika koefisien gaya gesek kedua box menjadi 0,1.",
            "5. Berdasarkan contoh soal kesembilan, jika massa box diperkecil menjadi A = 20 kg dan B = 5 kg sementara gaya F juga diperkecil menjadi 250 N, berapa gaya kontaknya saat ini?"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban_mtk = new String[]{
            "5 m/s2", "10 m/s2", "2 m/s2", "8 m/s2",
            "13 m/s2", "10 N", "45 N & 3 m/s2", "19 N",
            "17 N", "5 N", "40 N", "30 N",
            "20 N", "30 N", "10 N", "40 N",
            "50 N", "11 m/s2", "8 m/s2", "10 N"
    };

    //jawaban benar
    String[] jawaban_benar_mtk = new String[]{
            "5 m/s2",
            "45 N & 3 m/s2",
            "30 N",
            "30 N",
            "50 N"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_matematika);

        kuis1 = (TextView) findViewById(R.id.kuis);
        rg1 = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA1 = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB1 = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC1 = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD1 = (RadioButton) findViewById(R.id.pilihanD);

        kuis1.setText(pertanyaan_kuis_mtk[nomor1]);
        PilihanA1.setText(pilihan_jawaban_mtk[0]);
        PilihanB1.setText(pilihan_jawaban_mtk[1]);
        PilihanC1.setText(pilihan_jawaban_mtk[2]);
        PilihanD1.setText(pilihan_jawaban_mtk[3]);

        rg1.check(0);
        benar1 = 0;
        salah1 = 0;
    }

    public void next(View view) {
        if (PilihanA1.isChecked() || PilihanB1.isChecked() || PilihanC1.isChecked() || PilihanD1.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg1.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg1.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar_mtk[nomor1])) benar1++;
            else salah1++;
            nomor1++;
            if (nomor1 < pertanyaan_kuis_mtk.length) {
                kuis1.setText(pertanyaan_kuis_mtk[nomor1]);
                PilihanA1.setText(pilihan_jawaban_mtk[(nomor1 * 4) + 0]);
                PilihanB1.setText(pilihan_jawaban_mtk[(nomor1 * 4) + 1]);
                PilihanC1.setText(pilihan_jawaban_mtk[(nomor1 * 4) + 2]);
                PilihanD1.setText(pilihan_jawaban_mtk[(nomor1 * 4) + 3]);

            } else {
                hasil1 = benar1 * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis1.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Silahkan Pilih jawaban diatas",Toast.LENGTH_LONG).show();
        }
    }
}