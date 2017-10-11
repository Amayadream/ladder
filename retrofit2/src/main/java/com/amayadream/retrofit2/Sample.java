package com.amayadream.retrofit2;

import com.amayadream.retrofit2.api.result.Results;
import com.amayadream.retrofit2.client.SampleClient;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:59
 */
public class Sample {

    public static void main(String[] args) throws IOException {
        SampleClient client = new SampleClient("http://127.0.0.1:6666/", 10);
        Results results = client.getInfo("hello");
        System.out.println(results.toString());
    }

}
