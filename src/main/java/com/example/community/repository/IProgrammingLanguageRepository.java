package com.example.community.repository;

import com.example.community.entity.ProgrammingLanguage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProgrammingLanguageRepository extends CrudRepository<ProgrammingLanguage, Long> {
    
    List<ProgrammingLanguage> findAll();
}
