package com.amayadream.retrofit2.client.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2017.10.14 22:37
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Demo-Header", "true")
                .build();
        return chain.proceed(request);
    }

}
