package com.epam.module1.core;
@FunctionalInterface
public interface FunI {

    String perform(String s);

    default String start(){
        return "Hello";
    }
}
