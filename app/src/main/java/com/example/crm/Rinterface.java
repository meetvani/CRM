package com.example.crm;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Rinterface {

    @GET("cities.json")
    Call<object> getObject();
}
