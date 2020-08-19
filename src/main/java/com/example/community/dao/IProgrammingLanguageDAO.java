package com.example.community.dao;

import com.example.community.entity.ProgrammingLanguage;
import org.springframework.data.repository.CrudRepository;

public interface IProgrammingLanguageDAO extends CrudRepository<ProgrammingLanguage, Long> {
    
}
