<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>学生列表</title>
</head>
<body>
<h1>学生列表</h1>
<a href="student?action=new">添加新学生</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>学号</th>
    <th>姓名</th>
    <th>班级</th>
    <th>部门</th>
    <th>操作</th>
  </tr>
  <c:forEach items="${students}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.studentNo}</td>
      <td>${student.name}</td>
      <td>${student.classInfo.className}</td>
      <td>${student.classInfo.department}</td>
      <td>
        <a href="student?action=edit&id=${student.id}">编辑</a>
        <a href="student?action=delete&id=${student.id}"
           onclick="return confirm('确定要删除吗？')">删除</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>