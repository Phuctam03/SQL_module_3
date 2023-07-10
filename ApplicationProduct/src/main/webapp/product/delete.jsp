<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/10/2023
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete-Product</title>
</head>
<body>
<a href="/Products-Servlet">Back to list Products</a>
<h3>Are you sure?</h3>
<form method="post">
    <table>
        <tr>
            <th>NameProducts:</th>
            <td>${products.nameProduct}</td>
        </tr>
        <tr>
            <th>Price :</th>
            <td>${products.price}</td>
        </tr>
        <tr>
            <th>describeProduct:</th>
            <td>${products.describeProduct}</td>
        </tr>
        <tr>
            <th>manufacturers:</th>
            <td>${products.manufacturers}</td>
        </tr>

        <tr>
            <td><input type="submit" value="Delete Products"></td>
        </tr>
    </table>


</form>
</body>
</html>
