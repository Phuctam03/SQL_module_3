<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/16/2023
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search-Employee</title>
</head>
<body>
<table border="1" cellpadding="5">
     <tr>
         <th>ID</th>
         <th>Name</th>
         <th>Birthday</th>
         <th>id_card</th>
         <th>Salary</th>
         <th>Phone</th>
         <th>Email</th>
         <th>Address</th>
         <th>position</th>
         <th>Education_degree</th>
         <th>division</th>
         <th>userName</th>
     </tr>
    <tr>
        <td>${employees.employee_id}</td>
        <td>${employees.employee_name}</td>
        <td>
            ${employees.getBirthdayFormat()}
        </td>
        <td>${employees.employee_id_card}</td>
        <td>${employees.employee_salary}</td>
        <td>${employees.employee_phone}</td>
        <td>${employees.employee_email}</td>
        <td>${employees.employee_address}</td>
        <td>${employees.position_id.position_name}</td>
        <td>${employees.education_degree_id.education_degree_name}</td>
        <td>${employees.division_id.division_name}</td>
        <td>${employees.username.username}</td>
    </tr>

</table>

</body>
</html>
