package com.gambasoftware.gson;

import com.gambasoftware.gson.config.LocalDateDeserializer;
import com.gambasoftware.gson.config.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class GsonJsonParser<T> {
    private static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gson = gsonBuilder.create();
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }


    public T fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }
}
