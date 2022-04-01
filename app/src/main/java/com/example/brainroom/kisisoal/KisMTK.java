package com.example.brainroom.kisisoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.brainroom.R;
import com.example.brainroom.kisisoal.soal.SoalMtkSatu;

public class KisMTK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kis_mtk);

        TextView na = findViewById(R.id.nilaikisimtk);
        TextView nb = findViewById(R.id.nilaikisimtk1);


        na.setText(""+SoalMtkSatu.hasil);

        CardView a = findViewById(R.id.mtk1kis);
        CardView b = findViewById(R.id.mtk2kis);

        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(KisMTK.this, SoalMtkSatu.class);
                startActivity(intent);
            }
        });


    }
}
