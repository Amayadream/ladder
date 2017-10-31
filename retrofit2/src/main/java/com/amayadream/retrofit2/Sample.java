package com.amayadream.retrofit2;

import com.amayadream.retrofit2.api.result.Results;
import com.amayadream.retrofit2.client.SampleClient;

import java.io.IOException;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:59
 */
public class Sample {

    public static final String BASE_URL = "http://127.0.0.1:6666/";

    public static void main(String[] args) throws IOException {
        SampleClient client = new SampleClient(BASE_URL, 10);

        Results results1 = client.getBase("hello, getBase!");
        System.out.println(results1.toString());

        Results results2 = client.getPath("pathId", "hello, getPath");
        System.out.println(results2.toString());

        Results results3 = client.getMulti("Java", "Python", "NodeJS");
        System.out.println(results3.toString());

        Results results4 = client.postForm("pathId", "hello, postForm", "this is form value");
        System.out.println(results4.toString());

        Results results5 = client.postMulti("Java", "Python", "NodeJS");
        System.out.println(results5.toString());

        Results results6 = client.postBody("this is is", "this is message");
        System.out.println(results6.toString());
    }

}
