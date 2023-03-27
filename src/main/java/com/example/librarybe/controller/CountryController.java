package com.example.librarybe.controller;


import com.example.librarybe.model.Country;
import com.example.librarybe.service.CountryService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @PostMapping("/add")
    public void saveCountry(@RequestBody Country country){
        this.countryService.save(country);
    }


}
