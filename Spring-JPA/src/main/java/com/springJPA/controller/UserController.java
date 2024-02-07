package com.springJPA.controller;

import com.springJPA.model.User;
import com.springJPA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser=service.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("allUser")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUser=service.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("userId/{id}")
    public ResponseEntity<User> userById(@PathVariable int id){
        User userById=service.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user){
        User updateUser=service.updateUser(id,user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        String deleteUser=service.deleteUser(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
