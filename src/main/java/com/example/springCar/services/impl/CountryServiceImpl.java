package com.example.springCar.services.impl;

import com.example.springCar.models.Country;
import com.example.springCar.repositories.CountryRepository;
import com.example.springCar.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.repository=countryRepository;
    }

    @Override
    public List<Country> countryList() {
        return repository.findAll();
    }

    @Override
    public Country getCountry(Integer id) {
        return repository.getById(id);
    }

    @Override
    public boolean addCountry(Country c) {
        Country addCountry=repository.save(c);
        return addCountry!=null;
    }

    @Override
    public boolean editCountry(Integer id, Country c) {
       c.setId(id);
        Country addCountry=repository.save(c);
        return addCountry!=null;

    }

    @Override
    public void deleteCountry(Integer id) {
        repository.deleteById(id);
    }
}
