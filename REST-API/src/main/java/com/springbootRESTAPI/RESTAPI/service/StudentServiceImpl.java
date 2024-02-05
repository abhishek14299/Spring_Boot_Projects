package com.springbootRESTAPI.RESTAPI.service;

import com.springbootRESTAPI.RESTAPI.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    Student student;

    List<Student> studentData=new ArrayList<>();

    {
        studentData.add(new Student(1,"Aman","sharma"));
        studentData.add(new Student(2,"Naman","verma"));
        studentData.add(new Student(3,"Yash","tyagi"));
        studentData.add(new Student(4,"Utkarsh","gupta"));
    }
    @Override
    public Student getStudents() {

        return studentData.get(0) ;
    }

    @Override
    public List<Student> getStudentList() {
        return studentData;
    }

    @Override
    public Student getStudentsById(int studentId) {
        Iterator<Student> itr=studentData.listIterator();
        while(itr.hasNext()){
            Student itrStudent=itr.next();
            if(itrStudent.getId()==studentId){
                return itrStudent;
            }
        }
        return null;
    }

    @Override
    public Student getStudentsParam(int id, String firstName) {
        Iterator<Student> itr=studentData.listIterator();
        while(itr.hasNext()){
            Student itrStudent=itr.next();
            logger.info(itrStudent.getId()+ " "+itrStudent.getFirstName());
            if(itrStudent.getId()==id && itrStudent.getFirstName().equalsIgnoreCase(firstName)){
                return itrStudent;
            }
        }
        return null;
    }

    @Override
    public Student newStudent(Student student) {
        studentData.add(student);
        return student;
    }

    @Override
    public Student updateStudent(int studentId,Student student) {
        Iterator<Student> itr=studentData.listIterator();
        while(itr.hasNext()){
            Student itrStudent=itr.next();
            logger.info(itrStudent.getId()+ " "+itrStudent.getFirstName());
            if(itrStudent.getId()==studentId ){
                itrStudent.setFirstName(student.getFirstName());
                itrStudent.setLastName(student.getLastName());
                return itrStudent;
            }
        }
        return null;
    }

    @Override
    public Student deleteStudent(int studentId) {
        Student deletedStudent=studentData.get(studentId-1);
        studentData.remove(studentId-1);
        return deletedStudent;
    }
}
