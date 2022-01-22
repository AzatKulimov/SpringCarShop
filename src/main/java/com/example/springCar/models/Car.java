package com.example.springCar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



public class Car implements Serializable {
    private  Integer id;
    private  String mark;
    private  String modelka;
    private  int price;

    public Car(Integer id, String mark, String modelka, int price) {
        this.id = id;
        this.mark = mark;
        this.modelka = modelka;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return modelka;
    }

    public void setModel(String modelka) {
        this.modelka = modelka;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

