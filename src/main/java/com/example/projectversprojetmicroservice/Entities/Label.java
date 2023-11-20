package com.example.projectversprojetmicroservice.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Label {
    @Id
    private Long id;
    private String label;
    @ManyToOne
    @JoinColumn(name = "label_id",nullable = false)
    private Task task;
}
