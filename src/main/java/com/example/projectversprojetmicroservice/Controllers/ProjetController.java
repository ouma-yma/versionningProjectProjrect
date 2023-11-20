package com.example.projectversprojetmicroservice.Controllers;

import com.example.projectversprojetmicroservice.Entities.Project;
import com.example.projectversprojetmicroservice.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class ProjetController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/{id}")
    public Optional<Project> getLabelById(@PathVariable Long id) {
        return projectService.consulter(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addLabel(@RequestBody Project projet) {
        return projectService.addProject(projet);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        return projectService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Project projet) {
        return projectService.update(id, projet);
    }
}
