<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Nhân Viên</title>
</head>
<body>
<div class="">
    <a href="/HomeServlet" class="btn btn-warning mt-5 mb-5" style="margin-top: 20px;">Home</a>
    <h1 class="mt-3 text-center align-center">Danh Sách Nhân Viên</h1>
    <a href="/view-addNV" class="btn btn-primary ms-5 me-5" >Thêm Nhân Viên</a>
    <table class="table table-striped">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Họ và tên</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
        <th>Mật khẩu</th>
        <th>Cửa hàng</th>
        <th>Chức vụ</th>
        <th>Trạng thái</th>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${LIST_NV}">
            <tr>
                <td class="align-middle">${nv.id}</td>
                <td class="align-middle">${nv.ma}</td>
                <td class="align-middle"> ${nv.ho}${" "}${nv.tenDem}${" "}${nv.ten}</td>
                <td class="align-middle"> ${nv.gioiTinh}</td>
                <td class="align-middle"> ${nv.diaChi}</td>
                <td class="align-middle"> <f:formatDate value="${nv.ngaySinh}" pattern="dd/MM/yyyy"/></td>
                <td class="align-middle"> ${nv.sdt}</td>
                <td class="align-middle"> ${nv.matKhau}</td>
                <td class="align-middle"> ${nv.cuaHang.ten}</td>
                <td class="align-middle"> ${nv.chucVu.ten}</td>
                <td class="align-middle"> ${nv.trangThai==0?"Đi làm":"Nghỉ làm"}</td>
                <td>
                    <a href="/view-detailNV?id=${nv.id}" class="btn btn-primary">Detail</a>
                    <a href="/view-updateNV?id=${nv.id}" class="btn btn-success">Update</a>
                    <a href="/deleteNV?id=${nv.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>