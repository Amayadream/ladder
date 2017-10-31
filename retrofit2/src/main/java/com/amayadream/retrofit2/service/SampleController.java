package com.amayadream.retrofit2.service;

import com.amayadream.retrofit2.api.param.CommonBody;
import com.amayadream.retrofit2.api.result.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:35
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    /**
     * 简单的GET请求(QueryString)
     */
    @RequestMapping(value = "/get_base", method = RequestMethod.GET)
    public Results getBase(String message) {
        logger.info("[getBase] message: {}", message);
        return Results.ok();
    }

    /**
     * 带路径参数的GET请求
     */
    @RequestMapping(value = "/get_path/{path}", method = RequestMethod.GET)
    public Results getPath(@PathVariable String path, String message) {
        logger.info("[getPath] path: {}, message: {}", path, message);
        return Results.ok();
    }

    /**
     * 带复杂参数的GET请求
     */
    @RequestMapping(value = "/get_multi", method = RequestMethod.GET)
    public Results getMulti(String param1, String param2, String param3) {
        logger.info("[getMulti] param1: {}, param2: {}, param3: {}", param1, param2, param3);
        return Results.ok();
    }

    /**
     * 简单的表单POST
     */
    @RequestMapping(value = "/post_form/{path}", method = RequestMethod.POST)
    public Results postForm(@PathVariable String path, String message, String form) {
        logger.info("[postForm] path: {}, message: {}, form: {}", path, message, form);
        return Results.ok();
    }

    /**
     * 复杂表单POST
     */
    @RequestMapping(value = "/post_multi", method = RequestMethod.POST)
    public Results postMulti(String param1, String param2, String param3) {
        logger.info("[postMulti] param1: {}, param2: {}, param3: {}", param1, param2, param3);
        return Results.ok();
    }

    /**
     * Body POST
     */
    @RequestMapping(value = "/post_body", method = RequestMethod.POST)
    public Results postBody(@RequestBody CommonBody body) {
        logger.info("[postBody] body: {}", body);
        return Results.ok();
    }


}
