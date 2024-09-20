package com.example.firstbootproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import otherpackage.RandomService;

@Component
@RequiredArgsConstructor
public class GreetingService {
    private final RandomService randomService;
}
