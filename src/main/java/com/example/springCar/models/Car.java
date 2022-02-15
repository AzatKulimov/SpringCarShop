package com.example.springCar.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Car implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)// для автоинкримента
   private  Integer id;

    private  String mark;
    private  String modelka;
    private  int price;
    @ManyToOne(fetch = FetchType.EAGER)
     private Country country;

    public Car(){}
    public Car(Integer id, String mark, String modelka, int price, Country country) {
        this.id = id;
        this.mark = mark;
        this.modelka = modelka;
        this.price = price;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getId() {
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

