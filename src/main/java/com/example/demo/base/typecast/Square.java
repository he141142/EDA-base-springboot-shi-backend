package com.example.demo.base.typecast;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ShapeAnnotation(shapeName = "Square")
public class Square implements Shape {

    @Parameter(name = "length", type = ParamType.LENGTH)
    int length;

    @Parameter(name = "width", type = ParamType.WIDTH)
    int width;

    @Override
    public void draw() {
        System.out.println("Drawing Square With length: " + length + " and width: " + width);
    }
}
