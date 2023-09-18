package com.gambasoftware.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonJsonParser<T> {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public String toJson(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }


    public T fromJson(String json, Class<T> tClass) throws JsonProcessingException {
        return objectMapper.readValue(json, tClass);
    }

    public JsonNode fromJsonToJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }
}
