<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Chi Tiết Sản Phẩm</title>
</head>
<body>

<div class="">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3 text-center align-center">Danh Sách Chi Tiết Sản Phẩm</h1>
    <a href="/view-addCTSP" class="btn btn-primary ms-5 me-5" >Thêm Chi Tiết Sản Phẩm</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Hình ảnh</th>
        <th>Tên Sản Phẩm</th>
        <th>NSX</th>
        <th>Màu Sắc</th>
        <th>Dòng Sản Phẩm</th>
        <th>Năm BH</th>
        <th>Mô Tả</th>
        <th>Số Lượng Tồn</th>
        <th>Giá Nhập</th>
        <th>Giá Bán</th>
        </thead>
        <tbody>
        <c:forEach var="c" items="${LIST_CTSP}">
            <tr>
                <td class="align-middle">${c.id}</td>
                <td class="align-middle"><img src='/images/${c.hinhAnh}' style="width: 100px;height: 120px;" alt=""></td>
                <td class="align-middle">${c.sanPham.ten}</td>
                <td class="align-middle"> ${c.nsx.ten}</td>
                <td class="align-middle"> ${c.mauSac.ten}</td>
                <td class="align-middle"> ${c.dongSP.ten}</td>
                <td class="align-middle"> ${c.namBH}</td>
                <td class="align-middle"> ${c.moTa}</td>
                <td class="align-middle"> ${c.slt}</td>
                <td class="align-middle"> ${c.giaNhap}</td>
                <td class="align-middle"> ${c.giaBan}</td>
                <td>
                    <a href="/view-detailCTSP?id=${c.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateCTSP?id=${c.id}" class="btn btn-success">Update</a>
                    <a href="/deleteCTSP?id=${c.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>