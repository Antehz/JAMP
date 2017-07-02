package com.epam.module18.task1;

import java.util.ArrayList;
import java.util.List;

public class OOMClassloafer {

    public static void main(String[] args) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        while (true) {
            CustomClassloader customClassloader = new CustomClassloader();
            try {
                classes.add(customClassloader.loadClass("com.epam.module18.task1.OOM"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
