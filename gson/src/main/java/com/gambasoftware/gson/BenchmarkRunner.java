package com.gambasoftware.gson;

import com.gambasoftware.gson.models.User;
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
    public void gson_parsing_to_json() {
        GsonJsonParser<User> gsonJsonParser = new GsonJsonParser<>();
        User user = new User();
        user.setEmail("marlon@email.com");
        user.setId(666L);
        user.setName("Marlon");
        user.setCreatedAt(LocalDate.of(2023,9,11));

        String json = gsonJsonParser.toJson(user);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void gson_parsing_from_json() {
        GsonJsonParser<User> gsonJsonParser = new GsonJsonParser<>();
        String json = "{\"id\":666,\"email\":\"marlon@email.com\",\"name\":\"Marlon\",\"createdAt\":\"2023-09-11\"}";
        User resultObject = gsonJsonParser.fromJson(json, User.class);
    }
}
