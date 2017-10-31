package com.amayadream.retrofit2.client;

import com.amayadream.retrofit2.api.ApiService;
import com.amayadream.retrofit2.api.param.CommonBody;
import com.amayadream.retrofit2.api.result.Results;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    public Results getBase(String message) throws IOException {
        Call<Results> call = this.apiService.getBase(message);
        return this.execute(call);
    }

    public Results getPath(String path, String message) throws IOException {
        Call<Results> call = this.apiService.getPath(path, message);
        return this.execute(call);
    }

    public Results getMulti(String param1, String param2, String param3) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("param1", param1);
        map.put("param2", param2);
        map.put("param3", param3);
        Call<Results> call = this.apiService.getMulti(map);
        return this.execute(call);
    }

    public Results postForm(String path, String message, String form) throws IOException {
        Call<Results> call = this.apiService.postForm(path, message, form);
        return this.execute(call);
    }

    public Results postMulti(String param1, String param2, String param3) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("param1", param1);
        map.put("param2", param2);
        map.put("param3", param3);
        Call<Results> call = this.apiService.postMulti(map);
        return this.execute(call);
    }

    public Results postBody(String id, String message) throws IOException {
        CommonBody body = new CommonBody();
        body.setId(id);
        body.setMessage(message);
        Call<Results> call = this.apiService.postBody(body);
        return this.execute(call);
    }

}
