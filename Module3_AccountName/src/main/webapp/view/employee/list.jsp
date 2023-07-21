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
    <title>Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
</head>
<body class="container">
<h1><a href="/view/home/home.jsp">HOME</a></h1>
<a href="/employeeServlet?action=create">ADD new Employee</a></br>
<form action="/employeeServlet?action=Search" method="post">
    <input type="text" name="values"><span><input type="submit" value="Search"></span>
</form>
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
    <c:forEach items="${employeelist}" var="e">
        <tr>
            <td>${e.employee_id}</td>
            <td>${e.employee_name}</td>
            <td>
                    ${e.getBirthdayFormat()}
            </td>
            <td>${e.employee_id_card}</td>
            <td>
                <fmt:setLocale value="vn-vi"/>
                <fmt:formatNumber value="${e.employee_salary}" type="currency"/>
            </td>
            <td>${e.employee_phone}</td>
            <td>${e.employee_email}</td>
            <td>${e.employee_address}</td>
            <td>${e.position_id.position_name}</td>
            <td>${e.education_degree_id.education_degree_name}</td>
            <td>${e.division_id.division_name}</td>
            <td>${e.username.username}</td>
            <td>
                <a href="/employeeServlet?action=update&id=${e.employee_id}" >update</a>
                <a onclick="deletebyid(${e.employee_id})" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                DO YOU WANT TO DELETE ?
            </div>
            <div class="modal-footer">
              <a id="delete" href="">YES</a>
                <a href="/employeeServlet">NO</a>
            </div>
        </div>
    </div>
</div>
<script>
    function  deletebyid(id){
        let a = document.getElementById("delete");
        a.href = "/employeeServlet?action=delete&id="+ id;
    }

</script>
</body>
</html>
