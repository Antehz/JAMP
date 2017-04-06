package com.epam.module1.core;

public class efef {

    public static void main(String[] args) {
        FunI funI = (String s)-> s;
        System.out.println(funI.start());
        Thread thread = new Thread(()-> System.out.print("threadf"));
        thread.start();
    }
}
