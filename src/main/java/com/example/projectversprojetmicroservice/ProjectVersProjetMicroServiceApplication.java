package com.example.projectversprojetmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectVersProjetMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectVersProjetMicroServiceApplication.class, args);
    }

}
