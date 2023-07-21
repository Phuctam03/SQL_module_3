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
<html>
<head>
    <title>ListService</title>
</head>
<body class="container">
<h1><a href="/view/home/home.jsp">HOME</a></h1></br>
<a href="/ServiceServlet?action=create">ADD NEW SERVICE</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Service_area</th>
        <th>Service_cost</th>
        <th>Service_max_people</th>
        <th>rent_type_id</th>
        <th>Service_type_id</th>
        <th>standard_room</th>
        <th>description_other_convenience</th>
        <th>pool_area</th>
        <th>pool_area</th>
    </tr>
    <c:forEach items="${service}" var="s">
        <tr>
            <td>${s.service_id}</td>
            <td>${s.service_name}</td>
            <td>${s.service_area}</td>
            <td>${s.service_cost}</td>
            <td>${s.service_max_people}</td>
            <td>${s.rent_type_id.rent_type_name}</td>
            <td>${s.service_type_id.service_type_name}</td>
            <td>${s.standard_room}</td>
            <td>${s.description_other_convenience}</td>
            <td>${s.pool_area}</td>
            <td>${s.number_of_floors}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
