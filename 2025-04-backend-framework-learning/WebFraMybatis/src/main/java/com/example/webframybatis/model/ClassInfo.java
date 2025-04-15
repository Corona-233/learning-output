package com.example.webframybatis.model;

public class ClassInfo {
    private int classId;
    private String className;
    private String department;

    // 构造方法、getter和setter
    public ClassInfo() {}

    public ClassInfo(String className, String department) {
        this.className = className;
        this.department = department;
    }

    // 省略getter和setter方法...
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
