package com.example.springbootmybatis.service.impl;

import com.example.springbootmybatis.entity.Student;
import com.example.springbootmybatis.mapper.StudentMapper;
import com.example.springbootmybatis.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAll() {
        return studentMapper.findAll();
    }

    public Student getById(int id) {
        return studentMapper.findById(id);
    }

    public int add(Student student) {
        return studentMapper.insert(student);
    }

    public int update(Student student) {
        return studentMapper.update(student);
    }

    public int delete(int id) {
        return studentMapper.delete(id);
    }
}