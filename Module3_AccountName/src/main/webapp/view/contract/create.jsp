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
<html>
<head>
    <title>CreateContract</title>
</head>
<body>
<h1 style="color: blue">CREATE CONTRACT</h1>
<a href="/ContractServlet">Back to List Contract</a>
<form method="post" action="/ContractServlet?action=create">
    <table>
         <tr>
             <th>ID</th>
             <td><input type="text" name="id"></td>
         </tr>
        <tr>
            <th>start_date</th>
            <td><input  type="text" name="date1"></td>
        </tr>
        <tr>
            <th>end_date</th>
            <th><input type="text" name="date2"></th>
        </tr>
        <tr>
            <th>Deposit</th>
            <td><input type="text" name="deposit"></td>
        </tr>
        <tr>
            <th>total_money</th>
            <td><input type="text" name="total"></td>
        </tr>
        <tr>
            <th>Employee</th>
            <td>
                <select name="employeeId">
                    <c:forEach items="${employee}" var="e">
                        <option value="${e.employee_id}">${e.employee_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Customer</th>
            <td>
                <select name="customerId">
                    <c:forEach items="${customer}" var="c">
                     <option value="${c.customer_id}">${c.customer_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Service</th>
            <td>
                <select name="serviceId">
                    <c:forEach items="${service}" var="s">
                        <option value="${s.service_id}">${s.service_name}</option>
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
