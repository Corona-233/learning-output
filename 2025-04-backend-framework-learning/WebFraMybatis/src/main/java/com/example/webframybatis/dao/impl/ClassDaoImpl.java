package com.example.webframybatis.dao.impl;

import com.example.webframybatis.dao.ClassDao;
import com.example.webframybatis.model.ClassInfo;
import com.example.webframybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassDaoImpl implements ClassDao {
    @Override
    public List<ClassInfo> findAll() {
        try (SqlSession session = DBUtil.getSession()) {
            return session.selectList("class.findAll");
        }
    }

    @Override
    public ClassInfo findById(int id) {
        try (SqlSession session = DBUtil.getSession()) {
            return session.selectOne("class.findById", id);
        }
    }
}