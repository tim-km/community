package com.example.community.dao;

import com.example.community.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDAOImpl implements ICountryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Country> getCountries() {

        // TODO: write tests
        TypedQuery<Country> query =
                entityManager.createQuery("FROM Country ", Country.class);
        return query.getResultList();
    }
}
