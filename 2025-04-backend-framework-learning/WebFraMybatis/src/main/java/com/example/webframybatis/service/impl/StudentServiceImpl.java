package com.example.webframybatis.service.impl;

import com.example.webframybatis.dao.StudentDao;
import com.example.webframybatis.dao.impl.StudentDaoImpl;
import com.example.webframybatis.model.Student;
import com.example.webframybatis.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> getAllStudentsWithClass() {
        return studentDao.findAllWithClass();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public boolean addStudent(Student student) {
        try {
            studentDao.insert(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            studentDao.update(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try {
            studentDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}