package com.example.community.rest;

import com.example.community.entity.Project;
import com.example.community.service.IProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project")
public class ProjectRestController {

    private final IProjectService projectService;

    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    Iterable<Project> getProjects() {
        return projectService.getProjects();
    }

    @PostMapping(consumes = "application/json")
    Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }
}
