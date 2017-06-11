package com.epam.module16.task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        CarsFactory carsFactory = new CarsFactory();
        Collection<Car> cars = carsFactory.getCars();

        BiFunction<Integer, String, Collection<Car>> function = (integer, s) -> {
            return new ArrayList<Car>(integer);
        };


        // Supplier
        // Predicate
        // Function
        // BiFunction
        // Consumers
        // Comparator
        // Optional
        // Streams : filter, map, stream, match, count, reduce
        // map : getOrDef, computeIfAbsent, computeIf ...


        Map<String, Car> map = cars.stream()
                                   .collect(Collectors.toMap(o -> o.getName(), t -> t));
        map.getOrDefault("sdsdfvsdfewr", null );

    }
}
