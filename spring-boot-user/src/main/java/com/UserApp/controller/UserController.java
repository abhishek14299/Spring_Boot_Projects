package com.UserApp.controller;

import com.UserApp.dto.UserDto;
import com.UserApp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CRUD Spring Boot User Application",
description = "WEB Controller")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Create User Request",
            description = "HTTP POST Request to create User")
    @ApiResponse(description = "User Created Successfully",
    responseCode = "201")
    @PostMapping("createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        UserDto createdUser=service.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Fetch User By ID Request",
            description = "HTTP GET Request to Fetch User By Id")
    @ApiResponse(description = "User Fetched Successfully",
            responseCode = "200")
    @GetMapping("userid/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userWithId=service.getUserById(id);
        return new ResponseEntity<>(userWithId,HttpStatus.OK);
    }


    @Operation(summary = "Fetch User Data Request",
            description = "HTTP GET Request to Fetch User Data")
    @ApiResponse(description = "User Fetched Successfully",
            responseCode = "200")
    @GetMapping("userData")
    public ResponseEntity<List<UserDto>> getUserData(){
        List<UserDto> userData=service.getUserData();
        return new ResponseEntity<>(userData,HttpStatus.OK);
    }

    @Operation(summary = "Update User at ID Request",
            description = "HTTP PUT Request to Update User")
    @ApiResponse(description = "User Updated Successfully",
            responseCode = "200")
    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDto> updateUser (@PathVariable Long id,@RequestBody @Valid UserDto userDto){
        UserDto updatedUser=service.updateUser(id,userDto);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @Operation(summary = "Delete User at ID Request",
            description = "HTTP DELETE Request to Delete User")
    @ApiResponse(description = "User Deleted Successfully",
            responseCode = "200")
    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return "User Deleted Successfully";
    }
}
