package com.gambasoftware.fastjson2;

import com.gambasoftware.fastjson2.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fastjson2JsonParserTests {

    private Fastjson2JsonParser<User> fastjson2JsonParser = new Fastjson2JsonParser<>();

    @Test
    public void map_object_to_json() {
        long startTime = System.nanoTime();
        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        String json = fastjson2JsonParser.toJson(user);

        System.out.println("Took: " + (System.nanoTime() - startTime));
        assertEquals("{\"createdAt\":\"2023-09-11\",\"email\":\"marlon@email.com\",\"id\":666,\"name\":\"Marlon\"}", json);
    }

    @Test
    public void map_json_to_object() {
        long startTime = System.nanoTime();
        String json = "{\"id\":666,\"email\":\"marlon@email.com\",\"name\":\"Marlon\",\"createdAt\":\"2023-09-11\"}";
        User resultObject = fastjson2JsonParser.fromJson(json, User.class);

        System.out.println("Took: " + (System.nanoTime() - startTime));

        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        assertEquals(user.getId(), resultObject.getId());
        assertEquals(user.getName(), resultObject.getName());
        assertEquals(user.getEmail(), resultObject.getEmail());
        assertEquals(user.getCreatedAt(), resultObject.getCreatedAt());
    }

}
