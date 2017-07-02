package com.epam.module18.task2;

import java.util.ArrayList;
import java.util.Collection;

import com.epam.module16.task1.Car;
import com.epam.module16.task1.CarsFactory;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        for (int i=0; i<999999999; i++) {
            Collection<Car> carCollection = new ArrayList<>();
            for (int j=0; j<100; j++){
                carCollection.addAll(new CarsFactory().getCars());
            }
            carCollection = null;
        }

        for (int i=0; i<999999999; i++) {
            Collection<Car> carCollection = new ArrayList<>();
            for (int j=0; j<100; j++){
                carCollection.addAll(new CarsFactory().getCars());
            }
            carCollection = null;
        }
    }
    }


