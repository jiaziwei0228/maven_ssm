<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css">
<title>用户展示</title>
</head>
<body>
  登录用户：${loginUser.username}<br>
  <table border="1" cellpadding="3" cellspacing="0" align="center">
    <tr>
        <th>用户id</th>
        <th>用户姓名</th>
        <th>用户密码</th>
    </tr>
    <c:forEach items="${users}" var="user">
       <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
           <td>${user.password}</td> 
         <td><a href="delete?id=${user.id}">删除</a></td>
          <td><a href="update?user=${user}">更改</a></td>
       </tr>
    </c:forEach>
  </table>
  <a href="add">添加</a><br>
</body>
</html>