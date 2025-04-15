package com.example.webframybatis.service.impl;

import com.example.webframybatis.dao.ClassDao;
import com.example.webframybatis.dao.impl.ClassDaoImpl;
import com.example.webframybatis.model.ClassInfo;
import com.example.webframybatis.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClassDao classDao = new ClassDaoImpl();

    @Override
    public List<ClassInfo> getAllClasses() {
        return classDao.findAll();
    }

    @Override
    public ClassInfo getClassById(int id) {
        return classDao.findById(id);
    }
}