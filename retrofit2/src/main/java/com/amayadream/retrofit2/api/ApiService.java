package com.amayadream.retrofit2.api;

import com.amayadream.retrofit2.api.param.CommonBody;
import com.amayadream.retrofit2.api.result.Results;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:26
 */
public interface ApiService {

    /* --------------------- GET --------------------- */

    /**
     * 简单的GET请求(QueryString)
     */
    @GET(value = "sample/get_base")
    Call<Results> getBase(
            @Query(value = "message") String message
    );

    /**
     * 带路径参数的GET请求, 注意@Path必须在@Query之前
     */
    @GET(value = "sample/get_path/{path}")
    Call<Results> getPath(
            @Path(value = "path") String path,
            @Query(value = "message") String message
    );

    /**
     * 带复杂参数的GET请求
     */
    @GET(value = "sample/get_multi")
    Call<Results> getMulti(
            @QueryMap Map<String, String> map
    );


    /* --------------------- POST --------------------- */

    /**
     * 简单的表单POST
     */
    @FormUrlEncoded
    @POST(value = "sample/post_form/{path}")
    Call<Results> postForm(
            @Path(value = "path") String path,
            @Query(value = "message") String message,
            @Field(value = "form") String form
    );

    /**
     * 复杂表单POST
     */
    @FormUrlEncoded
    @POST(value = "sample/post_multi")
    Call<Results> postMulti(
            @FieldMap Map<String, String> map
    );

    /**
     * Body POST
     */
    @POST(value = "sample/post_body")
    Call<Results> postBody(
            @Body CommonBody body
    );


}
