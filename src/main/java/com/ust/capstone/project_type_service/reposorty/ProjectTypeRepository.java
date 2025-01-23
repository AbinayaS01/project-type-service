package com.ust.capstone.project_type_service.reposorty;

import com.ust.capstone.project_type_service.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

}
