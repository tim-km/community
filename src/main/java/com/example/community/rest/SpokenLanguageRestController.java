package com.example.community.rest;

import com.example.community.entity.SpokenLanguage;
import com.example.community.service.ISpokenLanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/spokenlanguage")
public class SpokenLanguageRestController {

    private final ISpokenLanguageService spokenLanguageService;

    public SpokenLanguageRestController(ISpokenLanguageService spokenLanguageService) {
        this.spokenLanguageService = spokenLanguageService;
    }

    @GetMapping
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguageService.getSpokenLanguages();
    }
}
