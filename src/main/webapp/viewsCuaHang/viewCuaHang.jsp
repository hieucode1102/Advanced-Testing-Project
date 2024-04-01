<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Cửa Hàng</title>
</head>
<body>

<div class="container">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3">Danh Sách Cửa Hàng</h1>
    <a href="/view-addCH" class="btn btn-primary" >Thêm Cửa Hàng</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Địa chỉ</th>
        <th>Thành phố</th>
        <th>Quốc gia</th>
        </thead>
        <tbody>
        <c:forEach var="ch" items="${LIST_CH}">
            <tr>
                <td class="align-middle">${ch.id}</td>
                <td class="align-middle">${ch.ma}</td>
                <td class="align-middle"> ${ch.ten}</td>
                <td class="align-middle"> ${ch.diaChi}</td>
                <td class="align-middle"> ${ch.thanhPho}</td>
                <td class="align-middle"> ${ch.quocGia}</td>
                <td>
                    <a href="/view-detailCH?id=${ch.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateCH?id=${ch.id}" class="btn btn-success">Update</a>
                    <a href="/deleteCH?id=${ch.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>