package com.springbootRESTAPI.RESTAPI.service;

import com.springbootRESTAPI.RESTAPI.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudents();

    List<Student> getStudentList();

    Student getStudentsById(int studentId);

    Student getStudentsParam(int id, String firstName);

    Student newStudent(Student student);

    Student updateStudent(int studentId,Student student);

    Student deleteStudent(int studentId);
}
