<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/12/2023
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create-Management</title>
</head>
<body>
<form method="post" action="/UserServlet?action=create">
    <table border="1" cellpadding="5">
        <caption><h2>Add New User</h2></caption>
        <tr>
            <th>User Name:</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>User Email :</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>Country :</th>
            <td><input type="text" name="country"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="ADD"></td>
        </tr>
    </table>

</form>


</body>
</html>
