package com.ust.capstone.project_type_service.service;

import com.ust.capstone.project_type_service.entity.ProjectType;
import com.ust.capstone.project_type_service.repository.ProjectTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeService {

    private final ProjectTypeRepository projectTypeRepository;

    @Autowired
    public ProjectTypeService(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    // Get all project types
    public List<ProjectType> getAllProjectTypes() {
        return projectTypeRepository.findAll();
    }

    // Get a specific project type by ID
    public Optional<ProjectType> getProjectTypeById(Long id) {
        return projectTypeRepository.findById(id);
    }

    // Create a new project type
    public ProjectType createProjectType(ProjectType projectType) {
        return projectTypeRepository.save(projectType);
    }

    // Update a project type
    public ProjectType updateProjectType(Long id, ProjectType projectType) {
        if (projectTypeRepository.existsById(id)) {
            projectType.setProjectId(id);
            return projectTypeRepository.save(projectType);
        }
        return null;
    }

    // Delete a project type by ID
    public boolean deleteProjectType(Long id) {
        if (projectTypeRepository.existsById(id)) {
            projectTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
