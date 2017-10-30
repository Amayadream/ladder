package com.amayadream.retrofit2.service.interceptor;

import com.alibaba.fastjson.JSON;
import com.amayadream.retrofit2.api.result.ResultConstant;
import com.amayadream.retrofit2.api.result.Results;
import com.amayadream.retrofit2.util.SignUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.TreeMap;

/**
 * @author :  Amayadream
 * @date :  2017.10.30 21:48
 */
@Component
public class SignInterceptor implements HandlerInterceptor {

    public static final Integer TIMESTAMP_TIMEOUT_SECONDS = 3 * 60;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //1.获取签名信息
        String sign = request.getHeader("Sign");
        String timestamp = request.getHeader("Timestamp");
        if (StringUtils.isEmpty(sign) || StringUtils.isEmpty(timestamp)) {
            this.print(response, Results.nok(ResultConstant.SIGN_EMPTY));
            return false;
        }

        //2.判断请求是否过期
        Long timestampL;
        try {
            timestampL = Long.valueOf(timestamp);
            if (Instant.now().getEpochSecond() - timestampL > TIMESTAMP_TIMEOUT_SECONDS) {
                this.print(response, Results.nok(ResultConstant.REQUEST_TIMEOUT));
            }
        } catch (NumberFormatException e) {
            this.print(response, Results.nok(ResultConstant.SIGN_EMPTY, "Timestamp格式错误"));
            return false;
        }

        //3.获取参数Map
        TreeMap<String, String[]> paramMap = SignUtils.buildParamMap(request);

        //4.生成签名
        String newSign = SignUtils.createSign(paramMap, timestampL, "secret");

        //5.签名校验
        if (!sign.equalsIgnoreCase(newSign)) {
            this.print(response, Results.nok(ResultConstant.SIGN_ERROR));
            return false;
        }

        return true;
    }

    /**
     * 返回错误信息
     * @param response
     * @param results
     * @throws IOException
     */
    private void print(HttpServletResponse response, Results results) throws IOException {
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(results.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
