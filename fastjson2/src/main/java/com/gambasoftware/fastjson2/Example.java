package com.gambasoftware.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.gambasoftware.fastjson2.models.User;

import java.time.LocalDate;

public class Example {

    public static void main(String[] args) {

        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        //Converting User object to Json
        String json = JSON.toJSONString(user);

        //Converting json to User object
        User userFromJson = JSON.parseObject(json, User.class);

    }
}
