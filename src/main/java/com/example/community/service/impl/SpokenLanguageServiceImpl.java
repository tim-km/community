package com.example.community.service.impl;

import com.example.community.dao.ISpokenLanguageDAO;
import com.example.community.entity.SpokenLanguage;
import com.example.community.service.ISpokenLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpokenLanguageServiceImpl implements ISpokenLanguageService {

    private final ISpokenLanguageDAO spokenLanguageDAO;

    public SpokenLanguageServiceImpl(ISpokenLanguageDAO spokenLanguageDAO) {
        this.spokenLanguageDAO = spokenLanguageDAO;
    }

    @Override
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguageDAO.getSpokenLanguages();
    }
}
