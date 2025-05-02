package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(int id);
    int add(Student student);
    int update(Student student);
    int delete(int id);
}