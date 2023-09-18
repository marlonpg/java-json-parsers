package com.gambasoftware.fastjson2;

import com.alibaba.fastjson2.JSON;

public class Fastjson2JsonParser<T> {

    public String toJson(Object object) {
        return JSON.toJSONString(object);
    }

    public T fromJson(String json, Class<T> tClass) {
        return JSON.parseObject(json, tClass);
    }
}
