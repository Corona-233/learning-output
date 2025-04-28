package com.example.springboot1.controller;

import com.example.springboot1.model.Student;
import com.example.springboot1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/id={id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public List<Student> findStudentsByNameOrMajor(@RequestParam(required = false) String name, @RequestParam(required = false) String major) {
        return studentService.findStudentsByNameOrMajor(name, major);
    }


    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }


    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }


    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
