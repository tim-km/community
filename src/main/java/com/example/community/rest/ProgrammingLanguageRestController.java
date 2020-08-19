package com.example.community.rest;

import com.example.community.entity.ProgrammingLanguage;
import com.example.community.service.IProgrammingLanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/programminglanguage")
public class ProgrammingLanguageRestController {

    private final IProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageRestController(IProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguageService.getProgrammingLanguages();
    }
}
