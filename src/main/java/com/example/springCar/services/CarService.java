package com.example.springCar.services;

import com.example.springCar.models.Car;

import java.util.List;

public interface CarService {
    Car getCar(int id);
    List<Car> getAllCars();
    boolean addCar(Car c);
    boolean editCar(Car c);
    void deleteCar(Car c);
}
