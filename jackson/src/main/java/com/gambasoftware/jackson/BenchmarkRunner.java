package com.gambasoftware.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gambasoftware.jackson.models.User;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void jackson_parsing_to_json() throws JsonProcessingException {
        JacksonJsonParser<User> jacksonJsonParser = new JacksonJsonParser<>();
        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023, 9, 11));

        String json = jacksonJsonParser.toJson(user);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void jackson_parsing_from_json() throws JsonProcessingException {
        JacksonJsonParser<User> jacksonJsonParser = new JacksonJsonParser<>();
        String json = "{\"id\":666,\"email\":\"marlon@email.com\",\"name\":\"Marlon\",\"createdAt\":\"2023-09-11\"}";
        User resultObject = jacksonJsonParser.fromJson(json, User.class);
    }
}
