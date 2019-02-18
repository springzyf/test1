<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>phone</td>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.userId}</td>
            <td>${u.userName}</td>
            <td>${u.password}</td>
            <td>${u.phone}</td>
        </tr>
    </c:forEach>


</table>
</body>
</html>



