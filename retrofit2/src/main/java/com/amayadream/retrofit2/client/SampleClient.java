package com.amayadream.retrofit2.client;

import com.amayadream.retrofit2.api.ApiService;
import com.amayadream.retrofit2.api.result.Results;
import retrofit2.Call;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:58
 */
public class SampleClient extends AbstractClient {

    private ApiService apiService;

    public SampleClient(String baseUrl) {
        super(baseUrl);
    }

    public SampleClient(String baseUrl, long timeoutSeconds) {
        super(baseUrl, timeoutSeconds);
    }

    @Override
    public void createService() {
        this.apiService = this.retrofit.create(ApiService.class);
    }

    public Results getInfo(String message) throws IOException {
        Call<Results> call = apiService.getInfo(message);
        return execute(call);
    }

}
