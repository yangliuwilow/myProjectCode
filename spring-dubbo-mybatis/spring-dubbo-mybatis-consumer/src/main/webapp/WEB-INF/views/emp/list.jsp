<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/16
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, table tr th, table tr td {
            border: 1px solid red;
        }

        table {
            width: 80%;
            min-height: 25px;
            line-height: 25px;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table style="border:1px red;">
    <tr>
        <td  >id</td>
        <td>empName</td>
        <td>empNo</td>
        <td>empAge</td>

    </tr>

    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.empName}</td>
            <td>${emp.empNo}</td>
            <td>${emp.empAge}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
