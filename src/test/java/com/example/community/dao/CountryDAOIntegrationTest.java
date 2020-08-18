package com.example.community.dao;

import com.example.community.entity.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class CountryDAOIntegrationTest {

    @Autowired
    private ICountryDAO countryDAO;

    @Test
    public void givenDataCreated_whenFindAll_thenSuccess() {
        List<Country> countryList = countryDAO.getCountries();
        Set<Country> countrySet = new HashSet<>(countryList);

        Assertions.assertEquals(countryList.size(), countrySet.size());
    }
}
