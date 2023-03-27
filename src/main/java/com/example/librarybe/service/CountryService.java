package com.example.librarybe.service;

import com.example.librarybe.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();
    void save(Country country);
}
