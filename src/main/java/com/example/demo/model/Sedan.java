package com.example.demo.model;

public class Sedan implements Car {

    private final String type = "Sedan";

    @Override
    public String getType() {
        return type;
    }
}
