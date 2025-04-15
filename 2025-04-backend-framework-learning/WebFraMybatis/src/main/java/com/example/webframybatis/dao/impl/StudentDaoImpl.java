package com.example.webframybatis.dao.impl;

import com.example.webframybatis.dao.StudentDao;
import com.example.webframybatis.model.Student;
import com.example.webframybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAllWithClass() {
        try (SqlSession session = DBUtil.getSession()) {
            return session.selectList("student.findAllWithClass");
        }
    }

    @Override
    public Student findById(int id) {
        try (SqlSession session = DBUtil.getSession()) {
            return session.selectOne("student.findById", id);
        }
    }

    @Override
    public void insert(Student student) {
        try (SqlSession session = DBUtil.getSession()) {
            session.insert("student.insert", student);
            session.commit();
        }
    }

    @Override
    public void update(Student student) {
        try (SqlSession session = DBUtil.getSession()) {
            session.update("student.update", student);
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession session = DBUtil.getSession()) {
            session.delete("student.delete", id);
            session.commit();
        }
    }
}