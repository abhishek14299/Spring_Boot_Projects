package com.springbootRESTAPI.RESTAPI.controller;

import com.springbootRESTAPI.RESTAPI.model.Student;
import com.springbootRESTAPI.RESTAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    //Spring Boot REST API for HTTP GET Request
    @GetMapping
    public ResponseEntity<Student> getStudent(){
        Student firstStudent= service.getStudents();
        return new ResponseEntity<>(firstStudent, HttpStatus.OK);
    }

    //Spring Boot REST API for HTTP GET Request and return all List of student
    @GetMapping("/list")
    public ResponseEntity<List<Student>> allStudent(){
        List<Student> studentData=service.getStudentList();
        return ResponseEntity.ok().header("Custom Header","newval").body(studentData);
    }

    //Spring Boot REST API for HTTP GET Request with Path Variables
    //Path Variable will extract data from URI field

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id")int studentId){
        Student studentById= service.getStudentsById(studentId );
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    //Spring Boot REST API for HTTP GET Request with Request Param
    //Request Param will extract data from URL


    @GetMapping("/param")
    public ResponseEntity<Student> getStudentParam(@RequestParam int id,@RequestParam String firstName){
        Student studentParam= service.getStudentsParam(id,firstName );
        return new ResponseEntity<>(studentParam, HttpStatus.OK);
    }

    //Spring Boot REST API for HTTP POST Request with RequestBody
    //RequestBody will extract data from HttpRequest and convert it into java Object

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newStudent=service.newStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }

    //Spring Boot REST API for HTTP PUT Request

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id")int studentId,@RequestBody Student student){
        Student updateSudent= service.updateStudent(studentId ,student);
        return new ResponseEntity<>(updateSudent, HttpStatus.OK);
    }


    //Spring Boot REST API for HTTP DELETE Request

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id")int studentId){
        Student deleteSudent= service.deleteStudent(studentId );
        return new ResponseEntity<>(deleteSudent, HttpStatus.OK);
    }



}
