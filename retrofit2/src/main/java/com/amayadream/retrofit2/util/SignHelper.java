package com.amayadream.retrofit2.util;

import com.google.common.base.Charsets;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 签名工具类
 * @author :  Amayadream
 * @date :  2017.10.31 23:04
 */
public class SignHelper {

    private static Logger logger = LoggerFactory.getLogger(SignHelper.class);

    /**
     * 从请求中获取body byte数组(Body)
     * @param request 请求对象
     * @return
     */
    public static byte[] getRequestBody(Request request) {
        byte[] bytes = null;
        RequestBody body = request.body();
        if (body == null) {
            return null;
        }
        boolean isForm = body instanceof FormBody;
        if (!isForm) {
            Buffer buffer = null;
            try {
                buffer = new Buffer();
                body.writeTo(buffer);
                bytes = buffer.readByteArray();
            } catch (IOException e) {
                logger.warn("[SignHelper]读取请求body出错", e);
                return null;
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
            }
        }
        return bytes;
    }

    /**
     * 从请求中获取body byte数组(Body)
     * @param request request对象
     * @return
     */
    public static byte[] getRequestBody(HttpServletRequest request) {
        InputStream in = null;
        byte[] bytes = null;
        try {
            in = request.getInputStream();
            if (in == null || in.available() == 0) {
                return null;
            }
            bytes = IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                IOUtils.closeQuietly(in);
            }
        }
        return bytes;
    }

    /**
     * 从请求中获取请求参数(QueryString + FormBody)
     * @param request 请求对象
     * @return
     */
    public static TreeMap<String, String[]> getRequestParams(Request request) {
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
     * 从请求中获取请求参数(QueryString + FormBody)
     * @param request 请求对象
     * @return
     */
    public static TreeMap<String, String[]> getRequestParams(HttpServletRequest request) {
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
     * @param params    请求参数(QueryString + FormBody)
     * @param body      请求体(Body)
     * @param timestamp 时间戳(单位: 秒)
     * @param secret    密钥
     * @return
     */
    public static String createSign(TreeMap<String, String[]> params, byte[] body, Long timestamp, String secret) {
        //1.初始化
        String paramsMd5 = "";
        String bodyMd5 = "";

        //2.生成请求参数MD5
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
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
            paramsMd5 = DigestUtils.md5DigestAsHex(sb.toString().getBytes(Charsets.UTF_8));
        }

        //3.生成请求体MD5
        if (body != null && body.length > 0) {
            bodyMd5 = DigestUtils.md5DigestAsHex(body);
        }

        //4.融合
        return DigestUtils.md5DigestAsHex((paramsMd5 + bodyMd5 + timestamp + secret).getBytes(Charsets.UTF_8));
    }

}
