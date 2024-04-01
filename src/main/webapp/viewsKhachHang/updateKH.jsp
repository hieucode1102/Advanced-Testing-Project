<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Update Khách Hàng</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="updateKH" method="post">
                <h1 class="mt-5 mb-5 text-center">Sửa Thông Tin Khách Hàng</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Khách Hàng:</h3>
                    <input type="text" class="form-control" name="id" value="${KH.id}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mã Khách Hàng:</h3>
                    <input type="text" class="form-control" name="ma" value="${KH.ma}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Khách Hàng:</h3>
                    <input type="text" class="form-control" name="ten" value="${KH.ten}"required  >
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Đệm:</h3>
                    <input type="text" class="form-control" name="tenDem"  value="${KH.tenDem}"required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Họ:</h3>
                    <input type="text" class="form-control" name="ho"  value="${KH.ho}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Ngày Sinh:</h3>
                    <f:formatDate pattern="yyyy-MM-dd" value="${KH.ngaySinh}" var="formattedDate" />
                    <input type="date" class="form-control" name="ngaySinh" value="${formattedDate}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Số điện thoại:</h3>
                    <input type="tel" class="form-control" name="sdt" value="${KH.sdt}" required>
                    <p style="color: red">${LOI_SDT}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Địa Chỉ:</h3>
                    <input type="text" class="form-control" name="diaChi"  value="${KH.diaChi}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Thành Phố:</h3>
                    <input type="text" class="form-control" name="thanhPho"  value="${KH.thanhPho}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Quốc Gia:</h3>
                    <input type="text" class="form-control" name="quocGia"  value="${KH.quocGia}" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mật khẩu:</h3>
                    <input type="text" class="form-control" name="matKhau"  value="${KH.matKhau}" required>
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="reset" class="btn btn-danger">Cancel</button>
                <a href="KhachHangServlet" class="btn btn-primary">Display Khach Hang</a>
            </form>

        </div>
    </div>
</div>
</body>
</html>
