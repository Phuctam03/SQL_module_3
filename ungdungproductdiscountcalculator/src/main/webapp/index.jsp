<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ứng dụng Product Discount Calculator</title>
</head>
<body>
<form method="post" action="/Discount">
    <table>
        <tr>
            <th>Product Description :</th>
            <td><input type="text" name="Product" placeholder="Mô tả của sản phẩm"></td>
        </tr>
        <tr>
            <th>List Price :</th>
            <td><input type="text" name="Price" placeholder="Giá niêm yết của sản phẩm"></td>
        </tr>
        <tr>
            <th>Discount Percent</th>
            <td><input type="text" name="Percent" placeholder="Tỷ lệ chiết khấu"></td>
        </tr>
        <tr>
             <td> <input type="submit" name="Calculate" value="Calculate Discount"></td>
        </tr>
    </table>

</form>

</body>
</html>