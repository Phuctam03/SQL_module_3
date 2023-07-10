<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/10/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-Products</title>
</head>
<body>
<form method="post" action="/Products-Servlet?action=create">
    <h1 style="color: royalblue">Create-Product</h1>
    <table style="text-align: left">
        <tr>
            <th>ID :</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>nameProduct :</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Price :</th>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <th>describeProduct :</th>
            <td><input type="text" name="describeProduct"></td>
        </tr>
        <tr>
            <th>manufacturers :</th>
            <td><input type="text" name="manufacturers"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="add new Product" style="background-color: royalblue"></td>
        </tr>
    </table>

</form>


</body>
</html>
