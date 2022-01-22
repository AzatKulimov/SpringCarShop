package com.example.springCar.models;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static int id = 1;

    static {
        cars.add(new Car(id++, "BMW", "530", 40000));
        cars.add(new Car(id++, "Mers", "E200", 44000));
        cars.add(new Car(id++, "Honda", "CR-V", 34000));
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static Car getTheCar(int id) {
        for (Car c : cars) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static void updateCar(int id, String mark, String modelka, int price) {
        for (Car c : cars) {
            if (c.getId() == id) {
                c.setMark(mark);
                c.setModel(modelka);
                c.setPrice(price);
            }
        }
    }

    public static void deleteCar(int id) {
        for (Car p : cars) {
            if (p.getId() == id) {
                cars.remove(p);
                break;
            }
        }
    }

    public static void addCar(Car p) {
        p.setId(id++);
        cars.add(p);
    }
}