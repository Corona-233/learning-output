package com.example.webframybatis.model;

public class Student {
    private int id;
    private String studentNo;
    private String name;
    private int classId;
    private ClassInfo classInfo;  // 关联的班级信息

    // 构造方法、getter和setter
    public Student() {}

    public Student(String studentNo, String name, int classId) {
        this.studentNo = studentNo;
        this.name = name;
        this.classId = classId;
    }

    // 省略getter和setter方法...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
}