package com.example.crm.citystate;

import com.example.crm.citystate.object;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Rinterface {

    @GET("cities.json")
    Call<object> getObject();
}
