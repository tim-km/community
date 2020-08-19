package com.example.community.dao;

import com.example.community.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface IProjectDAO extends CrudRepository<Project, Long> {
}
