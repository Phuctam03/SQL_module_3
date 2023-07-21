<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/20/2023
  Time: 10:48 PM
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
    <title>ListContract</title>
</head>
<body class="container">
<h1><a href="/view/home/home.jsp">HOME</a></h1>
<a href="/ContractServlet?action=create">ADD NEW CONTRACT</a>
<table border="1" cellpadding="4">
    <tr>
        <td>ID</td>
        <td>Start_Date</td>
        <td>End_Date</td>
        <td>Deposit</td>
        <td>Total_Money</td>
        <td>Employee</td>
        <td>Customer</td>
        <td>Service</td>
    </tr>

    <c:forEach items="${contracts}" var="c">
        <tr>
            <td>${c.contract_id}</td>
            <td>
                <fmt:formatDate value="${c.contract_start_day}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <fmt:formatDate value="${c.contract_end_day}" pattern="dd/MM/yyyy"/>
            </td>
            <td>${c.contract_deposit}</td>
            <td>${c.contract_total_money}</td>
            <td>${c.employee_id.employee_name}</td>
            <td>${c.customer_id.customer_name}</td>
            <td>${c.service_id.service_name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
