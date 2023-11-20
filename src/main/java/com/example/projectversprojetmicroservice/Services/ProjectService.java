package com.example.projectversprojetmicroservice.Services;
import com.example.projectversprojetmicroservice.Entities.Project;
import com.example.projectversprojetmicroservice.OpenfeignUser.OpenfeignUser;
import com.example.projectversprojetmicroservice.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class ProjectService {
    @Autowired
    private OpenfeignUser openfeignUser ;
    @Autowired
    private ProjectRepository projectRepository;
    public Optional<Project> consulter (Long id){
        Optional<Project> project = projectRepository.findById(id);
        project.get().setUser(openfeignUser.findById(project.get().getIdU()).get());
        return  project;
    }
    public ResponseEntity<String> delete(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            projectRepository.delete(project);
            return ResponseEntity.ok("Successfully deleted");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We don't have a project with this ID");
        }
    }

    public ResponseEntity<Object> addProject(Project project){
        Optional<Project> existingProject = projectRepository.findById(project.getId());

        if (existingProject.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project already exists!");
        } else {
            projectRepository.save(project);
        }

        return ResponseEntity.ok("Project added with success");
    }

    public ResponseEntity<String> update(Long id, Project project) {
        Optional<Project> optionalExistingProject = projectRepository.findById(id);

        if (optionalExistingProject.isPresent()) {
            Project existingProject = optionalExistingProject.get();

            if (project.getProjectName() != null) {
                existingProject.setProjectName(project.getProjectName());
            }
            if (project.getDescription() != null) {
                existingProject.setDescription(project.getDescription());
            }
            if (project.getStartDate() != null) {
                existingProject.setStartDate(project.getStartDate());
            }
            if (project.getEndDate() != null) {
                existingProject.setEndDate(project.getEndDate());
            }
            projectRepository.save(existingProject);
            return ResponseEntity.ok("Successfully updated");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "We don't have a project with this ID");
        }
    }



}
