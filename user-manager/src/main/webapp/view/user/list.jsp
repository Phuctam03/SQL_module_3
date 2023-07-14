<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/12/2023
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<div style="display: flex; justify-content: center">
    <a href="/UserServlet?action=create"style="height: 10px">Add new User</a>
    <table border="1" cellpadding="5">
        <form action="/UserServlet?action=Search" method="post">
           <div style="display: inline ;height: 20px">
               <input type="text" name="Search"><span><input type="submit" value="SEARCH"></span>
           </div>
        </form>
        <a href="/UserServlet?action=sort">SORT</a>
        <caption><h2>List Of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="/UserServlet?action=update&id=${user.id}">Edit</a>
                    <a href="/UserServlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
