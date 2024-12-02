package com.example.demo.base.typecast;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface Parameter {
    String name();

    ParamType type();
}
