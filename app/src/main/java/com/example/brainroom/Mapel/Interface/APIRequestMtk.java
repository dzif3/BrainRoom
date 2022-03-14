package com.example.brainroom.Mapel.Interface;

import com.example.brainroom.Mapel.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestMtk {
    @GET("datamtk.php")
    Call<ResponseModel> ardRetrieveDatamtk();
}
