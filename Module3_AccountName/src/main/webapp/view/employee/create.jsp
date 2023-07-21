<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/16/2023
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Create-Employee</title>
</head>
<body>
<h1>Create new Employee</h1>
<form action="/employeeServlet?action=create" method="post">
    <table>
         <tr>
             <td>ID</td>
             <td><input type="text" name="id"></td>
         </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday" placeholder="dd/MM/yyyy"></td>
        </tr>
        <tr>
            <td>Id_card</td>
            <td><input type="text" name="id_card"></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td>
                <select name="positionId">
                    <c:forEach items="${position}" var="p">
                         <option value="${p.position_id}">${p.position_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Education_degree</td>
            <td>
                <select name="educationId">
                    <c:forEach items="${education}" var="e">
                        <option value="${e.education_degree_id}">${e.education_degree_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Division</td>
            <td>
                <select name="divisionId">
                    <c:forEach items="${division}" var="d">
                        <option value="${d.division_id}">${d.division_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>Username</td>
            <td>
                <select name="username">
                    <c:forEach items="${user}" var="u">
                        <option value="${u.username}">${u.username}</option>
                    </c:forEach>
                </select>
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
