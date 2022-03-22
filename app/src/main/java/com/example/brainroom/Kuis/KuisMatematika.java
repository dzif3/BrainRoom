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
            "1. Berapa kelipatan angka 6 lebih besar dari 32 dan lebih kecil dari 50?",
            "2. Kelipatan persekutuan dari 4 dan 7 adalah ……",
            "3. Topik: Faktor Bilangan\n" +
                    "\n" +
                    "12, 15, 16, 20\n" +
                    "\n" +
                    "Manakah dari bilangan di atas yang tidak habis dibagi 4?",
            "4. Topik: Operasi Hitung Bilangan\n" +
                    "\n" +
                    "Sifat distributif dari 3 x (5-2) adalah …..\n" +
                    "\n",
            "5. Lambang bilangan bulat negatif dari tiga puluh enam yaitu …."
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban_mtk = new String[]{
            "34, 38, 49", "34, 39, 48", "36, 41, 49", "36, 42, 48",
            "26", "28", "32", "48",
            "12", "15", "16", "20",
            "3 x 5 – 2", "5 -2 x 3", "(3 x 5) – (3 x 2)", "(3 x 2) – 5",
            "Negatif 36", "36-", "+36", "-36"
    };

    //jawaban benar
    String[] jawaban_benar_mtk = new String[]{
            "36, 42, 48",
            "28",
            "15",
            "(3 x 5) – (3 x 2)",
            "-36"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_matematika);

        kuis1 = (TextView) findViewById(R.id.kuis1);
        rg1 = (RadioGroup) findViewById(R.id.pilihan1);
        PilihanA1 = (RadioButton) findViewById(R.id.pilihanA1);
        PilihanB1 = (RadioButton) findViewById(R.id.pilihanB1);
        PilihanC1 = (RadioButton) findViewById(R.id.pilihanC1);
        PilihanD1 = (RadioButton) findViewById(R.id.pilihanD1);

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
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Silahkan Pilih jawaban diatas",Toast.LENGTH_LONG).show();
        }
    }
}