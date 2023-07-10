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
    <title>update-Product</title>
</head>
<body>
<h1>Update-Product</h1>
<p>${message}</p>
<a href="/Products-Servlet">Back to list product</a>
<form method="post">
    <table style="text-align: left">
          <tr>
              <th>NameProduct:</th>
              <td><input type="text" name="name" id="name" value="${Product.nameProduct}" ></td>
          </tr>
        <tr>
            <th>Price :</th>
            <td><input type="text" name="price" id="price" value="${Product.price}"></td>
        </tr>
        <tr>
            <th>describeProduct:</th>
            <td><input type="text" name="describeProduct" id="describeProduct" value="${Product.describeProduct}" ></td>
        </tr>
        <tr>
            <th>manufacturers :</th>
            <td><input type="text" name="manufacturers" id="manufacturers" value="${Product.manufacturers}"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>

</body>
</html>
