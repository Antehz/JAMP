package com.epam.module3.task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Anton_Hrychanok on 2017-02-26.
 */
public class CustomClassLoader extends java.lang.ClassLoader {

    private String pathtobin;

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    public void invokeClassMethod(String classBinName, String methodName) {
        try {
            Class loadedMyClass = this.loadClass(classBinName);
            System.out.println("Loaded class name: " + loadedMyClass.getName());
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println(String.format("Class %s is loading ...", name));
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(String.format("Looking for class %c ..", name));
        Class foundClass = super.findClass(name);
        System.out.println(String.format("Class %c has been found!", foundClass.getName()));
        return foundClass;
    }
}
