package com.example.demo.base.typecast;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ShapeAnnotation(shapeName = "Circle")
public class Circle  implements Shape{

    @Parameter(name = "radius", type = ParamType.RADIUS)
    private int radius;

    @Override
    public void draw() {
        System.out.println("Drawing Circle With radius: " + radius);
    }
}
