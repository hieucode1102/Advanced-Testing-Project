<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Sản Phẩm</title>
</head>
<body>
<div class="container">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3">Danh Sách Sản Phẩm</h1>
    <a href="/view-addSP" class="btn btn-primary" >Thêm Sản Phẩm</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        </thead>
        <tbody>
        <c:forEach var="sp" items="${LIST_SP}">
            <tr>
                <td class="align-middle">${sp.id}</td>
                <td class="align-middle">${sp.ma}</td>
                <td class="align-middle"> ${sp.ten}</td>
                <td>
                    <a href="/view-detailSP?id=${sp.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateSP?id=${sp.id}" class="btn btn-success">Update</a>
                    <a href="/deleteSP?id=${sp.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>