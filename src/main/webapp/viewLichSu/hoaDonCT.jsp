
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Thống kê</title>
</head>
<body>

<div class="container" style="margin-top: 50px;">
    <table class="table table-bordered table-striped">
        <thead style="background-color: black;color: white;">
        <tr>
            <th scope="col">ID Hóa đơn</th>
            <th scope="col">Hình ảnh</th>
            <th scope="col">Sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LIST_HDCT}" var="c">
            <tr>
                <td>${c.hoaDon.id}</td>
                <td><img class="img-fluid w-100" style="height:100px " src='/images/${c.chiTietSP.hinhAnh}' alt=""></td>
                <td>${c.chiTietSP.sanPham.ten} ${c.chiTietSP.mauSac.ten} ${c.chiTietSP.nsx.ten} </td>
                <td>${c.soLuong}</td>
                <td>${c.donGia}</td>
            </tr>
        </c:forEach>
        </tbody>
        <a href="/LichSuServlet" class="btn btn-success" style="margin-top: 20px;">Display HD</a>
    </table>
</div>
</body>
</html>
