package com.example.community.rest;

import com.example.community.entity.Country;
import com.example.community.service.ICountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {

    private final ICountryService countryService;

    public CountryRestController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
