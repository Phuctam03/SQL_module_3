<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/11/2023
  Time: 1:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search-Product</title>
</head>
<body>
<a href="/Products-Servlet">Back to List Product</a>
<table border="1" >
    <tr>
        <th>ID</th>
        <th>NameProduct</th>
        <th>Price</th>
        <th>describeProduct</th>
        <th>manufacturers</th>
    </tr>
    <c:forEach items="${newProduct}" var="newProduct">
        <tr>
            <td>${newProduct.getId()}</td>
            <td>${newProduct.getNameProduct()}</td>
            <td>${newProduct.getPrice()}</td>
            <td>${newProduct.getDescribeProduct()}</td>
            <td>${newProduct.getManufacturers()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
