package com.example.community.service;

import com.example.community.entity.ProgrammingLanguage;

import java.util.List;

public interface IProgrammingLanguageService {

    Iterable<ProgrammingLanguage> getProgrammingLanguages();
}