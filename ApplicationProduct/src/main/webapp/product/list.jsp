<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/10/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List-Products</title>
</head>
<body>
<h1>List-Product</h1>
<a href="/Products-Servlet?action=create" style="color: red">Create new Product</a></br></br>
<form method="post" action="/Products-Servlet?action=Search">
   <input type="text" name="values"> <span><input type="submit" value="Search"></span></br>
</form>
<table border="1" >
    <tr>
        <th>ID</th>
        <th>NameProduct</th>
        <th>Price</th>
        <th>describeProduct</th>
        <th>manufacturers</th>
    </tr>
    <c:forEach items="${product}" var="p">
         <tr>
             <td>${p.id}</td>
             <td><a href="/Products-Servlet?action=view&id=${p.id}">${p.nameProduct}</a></td>
             <td>${p.price}</td>
             <td>${p.describeProduct}</td>
             <td>${p.manufacturers}</td>
             <td><a href="/Products-Servlet?action=update&id=${p.id}">Update</a></td>
             <td><a href="/Products-Servlet?action=delete&id=${p.id}">Delete</a></td>
         </tr>
    </c:forEach>

</table>
</body>
</html>
