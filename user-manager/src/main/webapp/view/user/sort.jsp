<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/14/2023
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UserServlet"></a>
<table border="1" cellpadding="5">
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

</body>
</html>
