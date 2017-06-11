package com.epam.module16.task1;

import java.util.ArrayList;
import java.util.Collection;

public class CarsFactory {

    public Collection<Car> getCars() {
        Collection<Car> cars = new ArrayList<>();
        cars.add(new Car("white", 1000, 5000, "c220", "Mercedes", true));
        cars.add(new Car("red", 2500, 100000, "x5", "BMV", true));
        cars.add(new Car("green", 6000, 10300, "vesta", "Lada", false));
        cars.add(new Car("black", 20600, 60000, "sandero", "Renault", true));
        cars.add(new Car("gray", 2060, 70000, "6", "Mazda", true));
        cars.add(new Car("white", 4000, 80000, "c200", "Mercedes", false));
        cars.add(new Car("white", 20300, 23000, "veyrone", "buggati", true));
        cars.add(new Car("green", 2300, 234000, "c2220", "Mercedes", false));
        cars.add(new Car("red", 2020, 10300, "xxx", "Aston Martin", false));
        cars.add(new Car("blue", 1200, 23000, "w200", "Mercedes", true));
        cars.add(new Car("blue", 1400, 5200, "Polo", "Volkswagen", false));
        cars.add(new Car("orange", 2300, 11200, "Touran", "Volkswagen", true));
        cars.add(new Car("black", 2030, 4500, "slc", "Mercedes", false));
        cars.add(new Car("white", 2550, 12000, "CC", "Volkswagen", true));
        cars.add(new Car("gray", 2260, 1600, "X6", "BMV", false));
        return cars;
    }
}
