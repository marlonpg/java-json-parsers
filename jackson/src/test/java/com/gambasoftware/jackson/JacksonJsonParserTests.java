package com.gambasoftware.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gambasoftware.jackson.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JacksonJsonParserTests {

    private JacksonJsonParser<User> userJacksonJsonParser = new JacksonJsonParser<>();

    @Test
    public void map_object_to_json() throws JsonProcessingException {
        long startTime = System.nanoTime();
        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        String json = userJacksonJsonParser.toJson(user);

        System.out.println("Took: " + (System.nanoTime() - startTime));

        assertEquals("{\"id\":666,\"email\":\"marlon@email.com\",\"name\":\"Marlon\",\"createdAt\":\"2023-09-11\"}", json);
    }

    @Test
    public void map_json_to_object() throws JsonProcessingException {
        long startTime = System.nanoTime();
        String json = "{\"id\":666,\"email\":\"marlon@email.com\",\"name\":\"Marlon\",\"createdAt\":\"2023-09-11\"}";
        User resultObject = userJacksonJsonParser.fromJson(json, User.class);

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
