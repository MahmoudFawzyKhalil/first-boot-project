package com.example.firstbootproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController // Rest controllers are also spring components / spring beans
// Now I want to define the base path of my endpoints in this controller
// http://localhost:8080/hello-world/hello
@RequestMapping("/hello-world")
@RequiredArgsConstructor
public class HelloWorldController {

    private final List<String> greetings = getGreetings();

    private final GreetingService greetingService;

    private static List<String> getGreetings() {
        List<String> list = new ArrayList<>();
        list.add("Hello World!");
        return list;
    }

    @GetMapping("/hello")
    public String hello() {
        int size = greetings.size();
        int i = new Random().nextInt(size);
        return greetings.get(i);
    }

    @PostMapping("/greetings/{greeting}")
    public List<String> addGreeting(@PathVariable("greeting") String x) {
        greetings.add(x);
        return greetings;
    }

    @GetMapping("/print-greeting-service-hashCode")
    public String getGreetingServiceHashCode() {
        return greetingService.toString();
    }
}
