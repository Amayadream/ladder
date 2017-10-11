package com.amayadream.retrofit2.api.result;

import com.alibaba.fastjson.JSONObject;

/**
 * Results中的data, 负责快速组装data的数据格式
 * @author : Amayadream
 * @date :   2017-08-17 14:40
 */
public class ResultData {

    private final JSONObject jsonObject;

    private ResultData(Builder builder) {
        this.jsonObject = builder.jsonObject;
    }

    public JSONObject value() {
        return this.jsonObject;
    }

    public static class Builder{

        private final JSONObject jsonObject;

        public Builder () {
            jsonObject = new JSONObject();
        }

        public Builder append(String displayName, Object obj) {
            if (obj instanceof ResultData) {
                jsonObject.put(displayName, ((ResultData) obj).value());
            } else {
                jsonObject.put(displayName, obj);
            }
            return this;
        }

        public ResultData build(){
            return new ResultData(this);
        }
    }

}
