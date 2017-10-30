package com.amayadream.retrofit2.api;

import com.amayadream.retrofit2.api.result.Results;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:26
 */
public interface ApiService {

    @GET(value = "sample/get_info")
    Call<Results> getInfo(
            @Query(value = "message") String message
    );

}
