<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/10/2023
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View-Products</title>
</head>
<body>
<h2>Products-details</h2>
<a href="/Products-Servlet">Back to list Products</a>
<table>
    <tr>
        <th>Name :</th>
        <td>${product.nameProduct}</td>
    </tr>
    <tr>
        <th>Price :</th>
        <td>${product.price}</td>
    </tr>
    <tr>
        <th>describeProduct:</th>
        <td>${product.describeProduct}</td>
    </tr>
    <tr>
        <th>manufacturers:</th>
        <td>${product.manufacturers}</td>
    </tr>
</table>

</body>
</html>
