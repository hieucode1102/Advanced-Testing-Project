<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Khách Hàng</title>
</head>
<body>

<div class="">
    <a href="HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3 text-center align-center">Danh Sách Khách Hàng</h1>
    <a href="view-addKH" class="btn btn-primary ms-5 me-5" >Thêm Khách Hàng</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Thành phố</th>
        <th>Quốc gia</th>
        <th>Mật khẩu</th>
        </thead>
        <tbody>
        <c:forEach var="kh" items="${LIST_KH}">
            <tr>
                <td class="align-middle">${kh.id}</td>
                <td class="align-middle">${kh.ma}</td>
                <td class="align-middle"> ${kh.ho}${" "}${kh.tenDem}${" "}${kh.ten}</td>
                <td class="align-middle"> <f:formatDate value="${kh.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                <td class="align-middle"> ${kh.sdt}</td>
                <td class="align-middle"> ${kh.diaChi}</td>
                <td class="align-middle"> ${kh.thanhPho}</td>
                <td class="align-middle"> ${kh.quocGia}</td>
                <td class="align-middle"> ${kh.matKhau}</td>
                <td>
                    <a href="view-detailKH?id=${kh.id}" class="btn btn-primary">Detail</a>
                    <a href="view-updateKH?id=${kh.id}" class="btn btn-success">Update</a>
                    <a href="deleteKH?id=${kh.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>