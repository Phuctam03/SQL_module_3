<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/7/2023
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
   <a href="/customers?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${customers_list}" var="c">
        <tr>
            <td><a href="/customers?action=view"></a></td>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
            <td><a href="/customer?action=edit&id=${c.id}">edit</a></td>
            <td><a href="/customer?action=delete&id=${c.id}">delete</a></td>
        </tr>

    </c:forEach>


</table>
</body>
</html>
