package com.amayadream.retrofit2.client;

import com.amayadream.retrofit2.api.result.Results;
import com.amayadream.retrofit2.client.converter.FastJsonConverterFactory;
import com.amayadream.retrofit2.client.interceptor.SignInterceptor;
import okhttp3.OkHttpClient;
import org.springframework.util.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 抽象客户端, 封装了与业务无关的请求过程
 * @author :  Amayadream
 * @date :  2017.10.11 22:26
 */
public abstract class AbstractClient {

    protected Retrofit retrofit;
    private long timeoutSeconds = 10;

    public AbstractClient(String baseUrl) {
        this.retrofit = createRetrofit(baseUrl);
        this.createService();
    }

    public AbstractClient(String baseUrl, long timeoutSeconds) {
        this.retrofit = createRetrofit(baseUrl);
        if (timeoutSeconds > 0) {
            this.timeoutSeconds = timeoutSeconds;
        }
        this.createService();
    }

    /**
     * 执行请求
     * @param call
     * @return
     * @throws IOException
     */
    public Results execute(Call<Results> call) throws IOException {
        Response<Results> response = call.execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException(String.format("request unsuccessful, http status: %s", response.code()));
        }
        return response.body();
    }

    /**
     * 创建Service
     */
    public abstract void createService();

    /**
     * 创建Retrofit
     * @param baseUrl 基础URL
     * @return
     */
    private Retrofit createRetrofit(String baseUrl) {
        if (StringUtils.isEmpty(baseUrl)) {
            throw new IllegalArgumentException("base url can not be empty!");
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .addInterceptor(new SignInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

}
