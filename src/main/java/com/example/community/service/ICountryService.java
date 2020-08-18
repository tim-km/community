package com.example.community.service;

import com.example.community.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICountryService {

    List<Country> getCountries();
}
