package com.example.community.dao.impl;

import com.example.community.dao.ISpokenLanguageDAO;
import com.example.community.entity.SpokenLanguage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SpokenLanguageDAOImpl implements ISpokenLanguageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SpokenLanguage> getSpokenLanguages() {

        TypedQuery<SpokenLanguage> query =
                entityManager.createQuery("FROM SpokenLanguage", SpokenLanguage.class);
        return query.getResultList();
    }
}
