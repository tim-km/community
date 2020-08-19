package com.example.community.service.impl;

import com.example.community.dao.IProjectDAO;
import com.example.community.entity.Project;
import com.example.community.service.IProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectDAO projectDAO;

    public ProjectServiceImpl(IProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public Project getProject(Long id) {
        Optional<Project> project = projectDAO.findById(id);
        // TODO handle NULL values for Project entity
        return project.get();
    }

    @Override
    public Iterable<Project> getProjects() {
        return projectDAO.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectDAO.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectDAO.deleteById(id);
    }
}
