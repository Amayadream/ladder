package com.amayadream.retrofit2.client.interceptor;

import com.amayadream.retrofit2.util.SignUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Instant;
import java.util.TreeMap;

/**
 * 签名拦截器
 * @author :  Amayadream
 * @date :  2017.10.30 21:07
 */
public class SignInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //1.获取当前时间
        Long timestamp = Instant.now().getEpochSecond();

        //2.获取paramMap
        TreeMap<String, String[]> paramMap = SignUtils.buildParamMap(request);

        //3.获取签名
        String sign = SignUtils.createSign(paramMap, timestamp, "secret");

        //4.添加签名头
        Request.Builder builder = request.newBuilder()
                .addHeader("Sign", sign)
                .addHeader("Timestamp", String.valueOf(timestamp));

        return chain.proceed(builder.build());
    }

}
