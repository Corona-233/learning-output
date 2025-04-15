package com.example.webframybatis.dao;

import com.example.webframybatis.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAllWithClass();
    Student findById(int id);
    void insert(Student student);
    void update(Student student);
    void delete(int id);
}