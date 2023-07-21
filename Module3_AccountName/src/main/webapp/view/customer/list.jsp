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
    <title>CustomerList</title>
</head>
<body class="container">
<h1><a href="/view/home/home.jsp">HOME</a></h1>
<a href="/CustomerServlet?action=create">Add new Customer</a></br>
<form action="/CustomerServlet?action=search" method="post">
    <input type="text" name="values"><span><input type="submit" value="Search"></span>
</form>
<table border="1" cellpadding="5">
     <tr>
         <th>ID</th>
         <th>CustomerType</th>
         <th>Name</th>
         <th>BirthDay</th>
         <th>Gender</th>
         <th>Id_card</th>
         <th>Phone</th>
         <th>Email</th>
         <th>Address</th>
     </tr>
    <c:forEach items="${CustomerList}" var="c">
        <tr>
            <td>${c.customer_id}</td>
            <td>${c.customer_type_id.customer_type_name}</td>
            <td>${c.customer_name}</td>
            <td>
                <fmt:formatDate value="${c.customer_birthday}" pattern="dd/MM/YYYY"/>
            </td>
            <td>
                <c:if test="${c.customer_gender == true}">
                    Male
                </c:if>
                <c:if test="${c.customer_gender == false}">Female</c:if>
            </td>
            <td>${c.customer_id_card}</td>
            <td>${c.customer_phone}</td>
            <td>${c.customer_email}</td>
            <td>${c.customer_address}</td>
            <td>
                <a href="/CustomerServlet?action=update&id=${c.customer_id}">Update</a>
                <a onclick="deletebyid(${c.customer_id})" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</a>
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
                <a href="/CustomerServlet">NO</a>
            </div>
        </div>
    </div>
</div>
<script>
    function  deletebyid(id){
        let a = document.getElementById("delete");
        a.href = "/CustomerServlet?action=delete&id="+ id;
    }
</script>

</body>
</html>
