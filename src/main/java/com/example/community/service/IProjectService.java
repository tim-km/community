package com.example.community.service;

import com.example.community.entity.Project;

public interface IProjectService {

    Project getProject(Long id);

    Iterable<Project> getProjects();
    
    Project saveProject(Project project);

    void deleteProject(Long id);
}
