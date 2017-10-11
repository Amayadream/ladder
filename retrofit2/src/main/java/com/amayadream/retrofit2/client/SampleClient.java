package com.amayadream.retrofit2.client;

import com.amayadream.retrofit2.api.ApiService;
import com.amayadream.retrofit2.api.result.Results;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:58
 */
public class SampleClient extends AbstractClient {

    public SampleClient(String baseUrl) {
        super(baseUrl);
    }

    public SampleClient(String baseUrl, long timeoutSeconds) {
        super(baseUrl, timeoutSeconds);
    }

    public Results getInfo(String message) throws IOException {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Results> call = apiService.getInfo("hello");
        Response<Results> response = call.execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException(String.format("request unsuccessful, http status: %s", response.code()));
        }
        return response.body();
    }
}
