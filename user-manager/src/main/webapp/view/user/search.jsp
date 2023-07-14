<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/14/2023
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search-User</title>
</head>
<body>
<a href="/UserServlet">Back to list User</a>
<table border="1" >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
     <tr>
         <td>${userManagement.id}</td>
         <td>${userManagement.name}</td>
         <td>${userManagement.email}</td>
         <td>${userManagement.country}</td>
     </tr>
</table>


</body>
</html>
