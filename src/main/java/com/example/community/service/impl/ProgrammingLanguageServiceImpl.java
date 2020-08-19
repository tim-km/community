package com.example.community.service.impl;

import com.example.community.entity.ProgrammingLanguage;
import com.example.community.dao.IProgrammingLanguageDAO;
import com.example.community.service.IProgrammingLanguageService;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageServiceImpl implements IProgrammingLanguageService {

    private final IProgrammingLanguageDAO programmingLanguageRepository;
    
    public ProgrammingLanguageServiceImpl(IProgrammingLanguageDAO programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public Iterable<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }
}
