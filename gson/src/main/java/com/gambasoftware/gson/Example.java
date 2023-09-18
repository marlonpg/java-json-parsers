package com.gambasoftware.gson;

import com.gambasoftware.gson.models.User;
import com.google.gson.Gson;

import java.time.LocalDate;

public class Example {

    public static void main(String[] args) {
        Gson gson = new Gson();

        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        //Converting User object to Json
        String json = gson.toJson(user);

        //Converting json to User object
        User userFromJson = gson.fromJson(json, User.class);

    }
}
