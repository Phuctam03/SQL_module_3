<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/19/2023
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>CreateCustomer</title>
</head>
<body>
<h1>Create new Customer</h1>
<form action="/CustomerServlet?action=create" method="post">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>CustomerType</th>
            <td>
                <select name="customerTypeId">
                    <c:forEach items="${customer_type}" var="c">
                        <option value="${c.customer_type_id}">${c.customer_type_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><input type="text" name="birthday" placeholder="dd/MM/yyyy"></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>
                <input type="radio" name="gender" value="Male" checked> Male
                <input type="radio" name="gender" value="Female">Female
            </td>
        </tr>
        <tr>
            <th>id_card</th>
            <td><input type="text" name="IdCard"></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>address</th>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="ADD">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
