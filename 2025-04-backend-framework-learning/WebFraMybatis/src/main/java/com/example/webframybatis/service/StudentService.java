package com.example.webframybatis.service;

import com.example.webframybatis.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudentsWithClass();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}