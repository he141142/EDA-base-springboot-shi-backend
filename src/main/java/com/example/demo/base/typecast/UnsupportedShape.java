package com.example.demo.base.typecast;

public class UnsupportedShape implements Shape {

    private String shapeName;

    @Override
    public void draw() {
        System.out.println("Unsupported Shape: " + shapeName);
    }
}
