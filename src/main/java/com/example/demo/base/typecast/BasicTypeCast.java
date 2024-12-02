package com.example.demo.base.typecast;

import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicTypeCast {
    public static <T> T CastToInterfaceType(Object myObj, Class<T> myInterface) {
       /*
       usage:
        var c = BasicTypeCast.CastToInterfaceType(new Circle(12), Circle.class);
        c.draw();
        */
        return myInterface.cast(myObj);
    }

    private static final String ERR_SHAPE_ANNO_MISSING = "ShapeAnnotation is missing";
    private static final String ERR_INVALID_SHAPE = "Invalid Shape";
    private static final String ERR_INVALID_SHAPE_PARAMS = "Invalid Shape Parameters";

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BasicTypeCast.class);

    public static void CalcShape(Shape shape) {
        Class<?> clazz = shape.getClass();
        if (!clazz.isAnnotationPresent(ShapeAnnotation.class)) {
            throw new IllegalArgumentException(ERR_SHAPE_ANNO_MISSING);
        }
        ShapeAnnotation shapeAnnotation = clazz.getAnnotation(ShapeAnnotation.class);
        System.out.println(shapeAnnotation.shapeName());
        if (!isValidShape(shapeAnnotation.shapeName())) {
            throw new IllegalArgumentException(ERR_INVALID_SHAPE);
        }
        if (!doesShapeHaveEnoughParameters(clazz, shape, shapeAnnotation.shapeName()))
            throw new IllegalArgumentException(ERR_INVALID_SHAPE_PARAMS);
    }


    public static boolean isValidShape(String shape) {
        return switch (shape) {
            case "Circle", "Square", "Rectangle" -> true;
            default -> false;
        };
    }

    public static boolean doesShapeHaveEnoughParameters(Class<?> clazz, Object realInstance, String shape) {
        Map<String, Map<String, Boolean>> ShapePresenter = new HashMap<>() {{
            put("Circle", new HashMap<>() {{
                put("radius", false);
            }});
            put("Square", new HashMap<>() {{
                put("length", false);
                put("width", false);
            }});
        }};

        Map<String, Boolean> ParameterPresenterByShape = ShapePresenter.get(shape);
        if (ParameterPresenterByShape == null || ParameterPresenterByShape.isEmpty()) {
            return false;
        }

        try {
            for (var field : Arrays.stream(clazz.getDeclaredFields()).toList()) {
                if (!field.canAccess(realInstance)) {
                    field.setAccessible(true);
                }
                Parameter p = field.getAnnotation(Parameter.class);
                if (p == null) {
                    continue;
                }
                if (ParameterPresenterByShape.containsKey(p.name())) {
                    ParameterPresenterByShape.put(p.name(), true);
                }
            }

        } catch (Exception e) {
            logger.error("Error while checking parameters for shape: {}", shape);
            return false;
        }

        return ParameterPresenterByShape.values().stream().allMatch(x -> x);
    }
}
