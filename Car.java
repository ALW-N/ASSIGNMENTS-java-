// File: com/car/sales/Car.java
package com.car.sales;

import com.car.sales.interfaces.Sales;

public class Car implements Sales {
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void sell() {
        System.out.println("Selling a car: " + model + " for $" + price);
    }
}
