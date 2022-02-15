package com.example.springCar.services;

import com.example.springCar.models.Country;

import java.util.List;

public interface CountryService {
    List<Country>countryList();
    Country getCountry(Integer id);
    boolean addCountry(Country c);
    boolean editCountry (Integer id, Country c);
    void  deleteCountry (Integer id);
}
