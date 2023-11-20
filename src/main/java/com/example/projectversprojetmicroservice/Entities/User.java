package com.example.projectversprojetmicroservice.Entities;


import lombok.Data;

@Data
public class User {

    private Long id;
    private String nom;
    private String prenom;
    private String login ;
    private String mdp;
    private String email;
}
