package com.example.projectversprojetmicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class Task {
    @Id
    private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "projet_id",nullable = false)
    private Project projet;
    @OneToMany(mappedBy = "task")
    private List<Label> labels;
}
