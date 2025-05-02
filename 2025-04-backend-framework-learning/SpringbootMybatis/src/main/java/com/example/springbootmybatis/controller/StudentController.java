package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.entity.Student;
import com.example.springbootmybatis.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public String add(@RequestBody Student student) {
        return studentService.add(student) > 0 ? "添加成功" : "添加失败";
    }

    @PutMapping
    public String update(@RequestBody Student student) {
        return studentService.update(student) > 0 ? "修改成功" : "修改失败";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return studentService.delete(id) > 0 ? "删除成功" : "删除失败";
    }
}