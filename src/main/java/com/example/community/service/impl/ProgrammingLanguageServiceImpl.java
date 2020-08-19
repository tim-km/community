package com.example.community.service.impl;

import com.example.community.entity.ProgrammingLanguage;
import com.example.community.repository.IProgrammingLanguageRepository;
import com.example.community.service.IProgrammingLanguageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageServiceImpl implements IProgrammingLanguageService {

    private final IProgrammingLanguageRepository programmingLanguageRepository;
    
    public ProgrammingLanguageServiceImpl(IProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }
}
