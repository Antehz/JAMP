package com.epam.module16.task1;

import java.util.Collection;

@FunctionalInterface
public interface ICarFactory {

    Collection<Car> generate(Integer count);

    default int getNumberOfCars(Collection<Car> cars) {
        return cars.size();
    }
}
