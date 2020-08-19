package com.example.community.service;

import com.example.community.entity.ProgrammingLanguage;

public interface IProgrammingLanguageService {

    Iterable<ProgrammingLanguage> getProgrammingLanguages();
}
