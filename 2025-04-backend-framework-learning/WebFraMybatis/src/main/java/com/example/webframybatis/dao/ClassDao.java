package com.example.webframybatis.dao;


import com.example.webframybatis.model.ClassInfo;

import java.util.List;

public interface ClassDao {
    List<ClassInfo> findAll();
    ClassInfo findById(int id);
}