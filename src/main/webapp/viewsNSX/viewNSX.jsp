<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>NSX</title>
</head>
<body>
<div class="container">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3">Danh Sách NSX</h1>
    <a href="/view-addNSX" class="btn btn-primary" >Thêm NSX</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        </thead>
        <tbody>
        <c:forEach var="n" items="${LIST_NSX}">
            <tr>
                <td class="align-middle">${n.id}</td>
                <td class="align-middle">${n.ma}</td>
                <td class="align-middle"> ${n.ten}</td>
                <td>
                    <a href="/view-detailNSX?id=${n.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateNSX?id=${n.id}" class="btn btn-success">Update</a>
                    <a href="/deleteNSX?id=${n.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>