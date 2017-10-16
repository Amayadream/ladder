package com.amayadream.retrofit2.service;

import com.amayadream.retrofit2.api.result.Results;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  Amayadream
 * @date :  2017.10.11 22:35
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @RequestMapping(value = "/get_info", method = RequestMethod.GET)
    public Results getInfo(String message, @RequestHeader("Demo-Header") String demoHeader) {
        System.out.println(demoHeader);
        return Results.ok(message);
    }

}
