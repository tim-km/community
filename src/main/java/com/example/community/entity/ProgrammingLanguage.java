package com.example.community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "programming_language")
public class ProgrammingLanguage {

    @Id
    private Long id;

    @Column
    private String name;
    
    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
