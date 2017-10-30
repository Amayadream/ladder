package com.amayadream.retrofit2.util;

import com.google.common.base.Charsets;
import okhttp3.FormBody;
import okhttp3.Request;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 签名工具类
 * @author :  Amayadream
 * @date :  2017.10.30 21:56
 */
public class SignUtils {

    /**
     * 构建请求参数Map
     * @param request 请求对象
     * @return
     */
    public static TreeMap<String, String[]> buildParamMap(Request request) {
        TreeMap<String, String[]> paramMap = new TreeMap<>();

        //1.组装Query参数
        Set<String> queryParamNames = request.url().queryParameterNames();
        if (!CollectionUtils.isEmpty(queryParamNames)) {
            for (String queryParamName : queryParamNames) {
                List<String> values = request.url().queryParameterValues(queryParamName);
                paramMap.put(queryParamName, values.toArray(new String[]{}));
            }
        }

        //2.组装form参数
        if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            if (formBody != null) {
                for (int i = 0; i < formBody.size(); i++) {
                    paramMap.put(formBody.name(i), new String[]{formBody.value(i)});
                }
            }
        }

        return paramMap;
    }

    /**
     * 组装paramMap
     * @param request
     * @return
     */
    public static TreeMap<String, String[]> buildParamMap(HttpServletRequest request) {
        TreeMap<String, String[]> paramMap = new TreeMap<>();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = enumeration.nextElement();
            String[] values = request.getParameterValues(paramName);
            paramMap.put(paramName, values);
        }
        return paramMap;
    }

    /**
     * 生成签名
     * @param paramMap  请求参数Map
     * @param timestamp 时间戳(秒)
     * @param secret    密钥
     * @return
     */
    public static String createSign(TreeMap<String, String[]> paramMap, Long timestamp, String secret) {
        //1.添加时间戳
        paramMap.put("timestamp", new String[]{String.valueOf(timestamp)});

        //2.拼接请求串
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(values[i]);
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }

        //3.计算签名
        return DigestUtils.md5DigestAsHex((secret + "|" + sb.toString()).getBytes(Charsets.UTF_8));
    }

}
