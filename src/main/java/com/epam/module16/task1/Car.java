package com.epam.module16.task1;

public class Car {

    private String color;
    private Integer weight;
    private Integer price;
    private String name;
    private String manufacturer;
    private boolean isAvailable;

    public Car(
        String color,
        Integer weight,
        Integer price,
        String name,
        String manufacturer,
        boolean isAvailable) {
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.manufacturer = manufacturer;
        this.isAvailable = isAvailable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
