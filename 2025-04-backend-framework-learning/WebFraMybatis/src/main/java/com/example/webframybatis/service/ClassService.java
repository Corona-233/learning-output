package com.example.webframybatis.service;

import com.example.webframybatis.model.ClassInfo;

import java.util.List;

public interface ClassService {
    List<ClassInfo> getAllClasses();
    ClassInfo getClassById(int id);
}