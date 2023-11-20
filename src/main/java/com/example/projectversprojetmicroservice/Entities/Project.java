package com.example.projectversprojetmicroservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class Project {
    @Id
    private Long id;
    private String projectName;
    private String description;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "projet")
    private List<Task> tasks;
    @Transient
    private User user;
    private int idU;
}
