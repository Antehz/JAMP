package com.epam.module5.task2.com.epam.moduleX.java8.task1;

@FunctionalInterface
public interface IValidator {

    boolean validate(String str);

    default Boolean isEmpty(String str) {
        return str.isEmpty();
    }
}
