<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>添加学生</title>
</head>
<body>
<h1>添加新学生</h1>
<form action="student" method="post">
  <input type="hidden" name="action" value="insert">
  学号: <input type="text" name="studentNo" required><br>
  姓名: <input type="text" name="name" required><br>
  班级:
  <select name="classId" required>
    <option value="">--请选择班级--</option>
    <c:forEach items="${classes}" var="classInfo">
      <option value="${classInfo.classId}">
          ${classInfo.className} (${classInfo.department})
      </option>
    </c:forEach>
  </select><br>
  <input type="submit" value="添加">
</form>
<a href="student">返回列表</a>
</body>
</html>