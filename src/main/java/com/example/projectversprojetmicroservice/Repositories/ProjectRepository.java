package com.example.projectversprojetmicroservice.Repositories;

import com.example.projectversprojetmicroservice.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
