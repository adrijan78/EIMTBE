package com.example.librarybe.service.impl;

import com.example.librarybe.model.Country;
import com.example.librarybe.repository.CountryRepository;
import com.example.librarybe.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private static CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public void save(Country country) {
        this.countryRepository.save(country);
    }
}
