package com.example.brainroom.Mapel.Interface;

import com.example.brainroom.Mapel.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("datamtk.php")
    Call<ResponseModel> ardRetrieveDatamtk();

    @GET("dataindo.php")
    Call<ResponseModel> ardRetrieveDataindo();

    @GET("dataing.php")
    Call<ResponseModel> ardRetrieveDataing();
}
