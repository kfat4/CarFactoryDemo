package com.example.demo.model;

public class Hatchback implements Car {
    private final String type = "Hatchback";

    @Override
    public String getType() {
        return type;
    }
}
