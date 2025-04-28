package com.example.springboot1.service;

import com.example.springboot1.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    List<Student> findStudentsByNameOrMajor(String name, String major);

    void addStudent(Student student);         // 新增
    void updateStudent(Student student);      // 修改
    void deleteStudent(Long id);              // 删除
}
