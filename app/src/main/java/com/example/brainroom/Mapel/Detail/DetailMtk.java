package com.example.brainroom.Mapel.Detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.brainroom.Mapel.Interface.APIRequestData;
import com.example.brainroom.Mapel.Model.DataModel;
import com.example.brainroom.Mapel.Model.ResponseModel;
import com.example.brainroom.Mapel.sAdapter.AdapterDetail;
import com.example.brainroom.Mapel.server.RetroServer;
import com.example.brainroom.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMtk extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvadapter;
    private RecyclerView.LayoutManager rvlayma;
    private List<DataModel> listMapel = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapel_detail_mtk);

        recyclerView = findViewById(R.id.rv_detail_mtk);
        rvlayma = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(rvlayma);
        mapelData();

    }

    private void mapelData() {
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardRetrieveDatamtk();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                listMapel = response.body().getData();

                rvadapter = new AdapterDetail(DetailMtk.this, listMapel);
                recyclerView.setAdapter(rvadapter);
                rvadapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(DetailMtk.this, "gagal" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

