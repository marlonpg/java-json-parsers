package com.gambasoftware.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gambasoftware.jackson.models.User;

import java.time.LocalDate;

public class Example {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        //Converting User object to Json
        String json = objectMapper.writeValueAsString(user);

        //Converting json to User object
        User userFromJson = objectMapper.readValue(json, User.class);

    }
}
