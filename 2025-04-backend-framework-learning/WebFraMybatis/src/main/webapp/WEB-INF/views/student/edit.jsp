<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>编辑学生</title>
</head>
<body>
<h1>编辑学生信息</h1>
<form action="student" method="post">
  <input type="hidden" name="action" value="update">
  <input type="hidden" name="id" value="${student.id}">
  学号: <input type="text" name="studentNo" value="${student.studentNo}" required><br>
  姓名: <input type="text" name="name" value="${student.name}" required><br>
  班级:
  <select name="classId" required>
    <option value="">--请选择班级--</option>
    <c:forEach items="${classes}" var="classInfo">
      <option value="${classInfo.classId}"
        ${student.classId == classInfo.classId ? 'selected' : ''}>
          ${classInfo.className} (${classInfo.department})
      </option>
    </c:forEach>
  </select><br>
  <input type="submit" value="更新">
</form>
<a href="student">返回列表</a>
</body>
</html>
