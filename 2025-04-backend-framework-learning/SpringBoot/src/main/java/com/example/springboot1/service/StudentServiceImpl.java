package com.example.springboot1.service;

import com.example.springboot1.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    //data
    private final List<Student> students = new ArrayList<>();

    public StudentServiceImpl() {
        students.add(new Student(1L, "Aab", 20, "计221-1"));
        students.add(new Student(2L, "Bb", 19, "计221-1"));
        students.add(new Student(3L, "Cc", 18, "计221-2"));
        students.add(new Student(4L, "Dda", 20, "计221-2"));
        students.add(new Student(5L, "Ea", 21, "计222-1"));
        students.add(new Student(6L, "Eb", 20, "计222-1"));
        students.add(new Student(7L, "Aabc", 20, "计222-2"));
        students.add(new Student(8L, "Bbdd", 11, "计222-2"));
        students.add(new Student(9L, "CcAA", 18, "计223-1"));
        students.add(new Student(10L, "Ccbb", 20, "计223-1"));
        students.add(new Student(11L, "aaaa", 18, "计223-2"));
        students.add(new Student(12L, "ABCD", 18, "计223-2"));
        students.add(new Student(13L, "EEC", 19, "计228-1"));
        students.add(new Student(14L, "eea", 20, "计228-1"));
        students.add(new Student(15L, "bbb", 19, "计228-2"));
        students.add(new Student(16L, "fff", 21, "计228-2"));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Student> findStudentsByNameOrMajor(String name, String major) {
        return students.stream().filter(student -> (name == null || student.getName().contains(name)) && (major == null || student.getMajor().contains(major))).collect(Collectors.toList());
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                return;
            }
        }
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }


}
