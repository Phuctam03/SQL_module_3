<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/19/2023
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>CreateService</title>
</head>
<body>
<h1>CREATE NEW SERVICE</h1>
<form method="post">
    <table>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>service_area</th>
            <td><input type="text" name="service_area"></td>
        </tr>
        <tr>
            <th>service_cost</th>
            <td><input type="text" name="cost"></td>
        </tr>
        <tr>
            <th>service_max_people</th>
            <td><input type="text" name="people"></td>
        </tr>
        <tr>
            <th>Rent_Type</th>
            <td>
                <select name="rent_type_id">
                    <c:forEach items="${rent_type}" var="r">
                        <option value="${r.rent_type_id}">${r.rent_type_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Service_type</th>
            <td>
                <select name="service_type_id">
                    <c:forEach items="${service_type}" var="s">
                        <option value="${s.service_type_id}">${s.service_type_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>standard_room</th>
            <td>
                <input type="text" name="room">
            </td>
        </tr>
        <tr>
            <th>description_other_convenience</th>
            <td>
                <input type="text" name="convenience">
            </td>
        </tr>
        <tr>
            <th>pool_area</th>
            <td>
                <input type="text" name="pool_area">
            </td>
        </tr>
        <tr>
            <th>number_of_floors</th>
            <td>
                <input type="text"name="number_of_floors">
            </td>
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
