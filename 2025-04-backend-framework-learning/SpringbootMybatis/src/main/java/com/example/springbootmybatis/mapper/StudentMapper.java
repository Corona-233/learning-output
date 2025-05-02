package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
    Student findById(int id);
    int insert(Student student);
    int update(Student student);
    int delete(int id);
}
