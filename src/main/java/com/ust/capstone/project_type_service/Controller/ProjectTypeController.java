package com.ust.capstone.project_type_service.Controller;

import com.ust.capstone.project_type_service.entity.ProjectType;
import com.ust.capstone.project_type_service.service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project-types")
public class ProjectTypeController {

    private final ProjectTypeService projectTypeService;

    @Autowired
    public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService = projectTypeService;
    }

    // Fetch all project types
    
    @GetMapping
    public List<ProjectType> getAllProjectTypes() {
        return projectTypeService.getAllProjectTypes();
    }

    // Fetch a specific project type by ID
    
    @GetMapping("/{id}")
    public ResponseEntity<ProjectType> getProjectTypeById(@PathVariable Long id) {
        Optional<ProjectType> projectType = projectTypeService.getProjectTypeById(id);
        return projectType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new project type
    
    @PostMapping
    public ResponseEntity<ProjectType> createProjectType(@RequestBody ProjectType projectType) {
        ProjectType createdProjectType = projectTypeService.createProjectType(projectType);
        return new ResponseEntity<>(createdProjectType, HttpStatus.CREATED);
    }

    // Update an existing project type
    
    @PutMapping("/{id}")
    public ResponseEntity<ProjectType> updateProjectType(@PathVariable Long id, @RequestBody ProjectType projectType) {
        ProjectType updatedProjectType = projectTypeService.updateProjectType(id, projectType);
        return updatedProjectType != null ? ResponseEntity.ok(updatedProjectType) : ResponseEntity.notFound().build();
    }

    // Delete a project type by ID
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectType(@PathVariable Long id) {
        boolean isDeleted = projectTypeService.deleteProjectType(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
