package com.amayadream.retrofit2.service;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2017.10.12 22:42
 */
@RestController
@RequestMapping(value = "/")
public class RestErrorController extends AbstractErrorController {

    public RestErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(value = "/error")
    public Map<String, Object> error(HttpServletRequest request) {
        Map<String, Object> errorMap = getErrorAttributes(request, true);
        return errorMap;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        return super.getErrorAttributes(request, includeStackTrace);
    }

}
