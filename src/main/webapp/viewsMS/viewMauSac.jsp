<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Màu Sắc</title>
</head>
<body>

<div class="container">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3">Danh Sách Màu Sắc</h1>
    <a href="/view-addMS" class="btn btn-primary" >Thêm Màu Sắc</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        </thead>
        <tbody>
        <c:forEach var="ms" items="${LIST_MS}">
            <tr>
                <td class="align-middle">${ms.id}</td>
                <td class="align-middle">${ms.ma}</td>
                <td class="align-middle"> ${ms.ten}</td>
                <td>
                    <a href="/view-detailMS?id=${ms.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateMS?id=${ms.id}" class="btn btn-success">Update</a>
                    <a href="/deleteMS?id=${ms.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>