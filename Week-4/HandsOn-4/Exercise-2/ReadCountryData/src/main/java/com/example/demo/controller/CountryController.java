package com.example.demo.controller;

import com.example.demo.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        logger.info("Start");
        logger.info("Country Code: {}", country.getCode());
        logger.info("Country Name: {}", country.getName());
        return country;
    }
}
