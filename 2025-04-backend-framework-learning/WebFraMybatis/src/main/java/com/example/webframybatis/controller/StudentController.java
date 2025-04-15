package com.example.webframybatis.controller;

import com.example.webframybatis.model.Student;
import com.example.webframybatis.model.ClassInfo;
import com.example.webframybatis.service.ClassService;
import com.example.webframybatis.service.StudentService;
import com.example.webframybatis.service.impl.ClassServiceImpl;
import com.example.webframybatis.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private ClassService classService = new ClassServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            default:
                listStudents(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("insert".equals(action)) {
            insertStudent(req, resp);
        } else if ("update".equals(action)) {
            updateStudent(req, resp);
        } else {
            listStudents(req, resp);
        }
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudentsWithClass();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ClassInfo> classes = classService.getAllClasses();
        req.setAttribute("classes", classes);
        req.getRequestDispatcher("/WEB-INF/views/student/add.jsp").forward(req, resp);
        System.out.println("班级列表: " + classes); // 检查是否查询到数据
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudentById(id);
        List<ClassInfo> classes = classService.getAllClasses();

        req.setAttribute("student", student);
        req.setAttribute("classes", classes);
        req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String studentNo = req.getParameter("studentNo");
        String name = req.getParameter("name");
        int classId = Integer.parseInt(req.getParameter("classId"));

        Student newStudent = new Student(studentNo, name, classId);
        studentService.addStudent(newStudent);
        resp.sendRedirect("student");
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String studentNo = req.getParameter("studentNo");
        String name = req.getParameter("name");
        int classId = Integer.parseInt(req.getParameter("classId"));

        Student student = new Student(studentNo, name, classId);
        student.setId(id);
        studentService.updateStudent(student);
        resp.sendRedirect("student");
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        resp.sendRedirect("student");
    }
}
