package com.amayadream.retrofit2.client;

import com.amayadream.retrofit2.client.converter.FastJsonConverterFactory;
import okhttp3.OkHttpClient;
import org.springframework.util.StringUtils;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:26
 */
public abstract class AbstractClient<T> {

    protected Retrofit retrofit;
    private long timeoutSeconds = 10;

    public AbstractClient(String baseUrl) {
        this.retrofit = createRetrofit(baseUrl);
    }

    public AbstractClient(String baseUrl, long timeoutSeconds) {
        this.retrofit = createRetrofit(baseUrl);
        if (timeoutSeconds > 0) {
            this.timeoutSeconds = timeoutSeconds;
        }
    }

    private Retrofit createRetrofit(String baseUrl) {
        if (StringUtils.isEmpty(baseUrl)) {
            throw new IllegalArgumentException("base url can not be empty!");
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

}
