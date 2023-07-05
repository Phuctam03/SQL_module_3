<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/5/2023
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<h3>Calculator</h3>
<form action="/Calulator-Controller" method="post">
    <table>
        <tr>
            <th>First operand:</th>
            <td><input type="text" name="FirstOperand"></td>
        </tr>
        <tr>
            <th>Operator:</th>
            <td><select name="operator">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select></td>
        </tr>
        <tr>
            <th>Second operand :</th>
            <td><input type="text" name="SecondOperand"></td>
        </tr>

         <tr>
             <td><input type="submit" value="Calculate"></td>
         </tr>
    </table>

</form>
</body>
</html>
