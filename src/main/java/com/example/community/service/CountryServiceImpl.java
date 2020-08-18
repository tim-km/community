package com.example.community.service;

import com.example.community.dao.ICountryDAO;
import com.example.community.entity.Country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {

    private final ICountryDAO countryDao;

    public CountryServiceImpl(ICountryDAO countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public List<Country> getCountries() {
        return countryDao.getCountries();
    }
}
