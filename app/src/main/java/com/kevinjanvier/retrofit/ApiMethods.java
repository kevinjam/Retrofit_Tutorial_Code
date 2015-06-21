package com.kevinjanvier.retrofit;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by user on 6/17/15.
 */
public interface ApiMethods {
    @GET("/get/curators.json")
    void getCurators(
            @Query("api_key") String key, Callback<Curator> cb
    );
}
