package com.example.springCar.services.impl;

import com.example.springCar.models.Car;
import com.example.springCar.repositories.CarRepository;
import com.example.springCar.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car getCar(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return repository.findAll();
    }

    @Override
    public boolean addCar(Car c) {
        Car addedCar=repository.save(c);
        return addedCar!=null;
    }

    @Override
    public boolean editCar(Car c) {
        Car addedCar=repository.save(c);
        return addedCar!=null;}

    @Override
    public void deleteCar(Car c) {
         repository.delete(c);
    }

}
