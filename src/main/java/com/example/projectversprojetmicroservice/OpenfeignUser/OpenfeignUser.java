package com.example.projectversprojetmicroservice.OpenfeignUser;

import com.example.projectversprojetmicroservice.Entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
@FeignClient(name = "microserviceUser", url = "http://localhost:8093")

public interface OpenfeignUser {
    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody User user) ;

    @GetMapping("/get/{id}")
    public Optional<User> findById(@PathVariable long id) ;

}
