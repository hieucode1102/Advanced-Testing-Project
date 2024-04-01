<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Detail Nhân Viên</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action=""  >
                <h1 class="mt-5 mb-5 text-center">Thông Tin Nhân Viên</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Nhân Viên:</h3>
                    <input type="text" class="form-control" name="id" value="${NV.id}">
                    <p style="color:red;">${LOI_MA}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mã Nhân Viên:</h3>
                    <input type="text" class="form-control" name="ma" value="${NV.ma}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Nhân Viên:</h3>
                    <input type="text" class="form-control" name="ten"  value="${NV.ten}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Đệm:</h3>
                    <input type="text" class="form-control" name="tenDem"  value="${NV.tenDem}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Họ:</h3>
                    <input type="text" class="form-control" name="ho"  value="${NV.ho}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Giới tính</h3>
                    <label class="checkbox-inline"><input type="radio" value="Nam" <c:if test="${NV.gioiTinh=='Nam'}">checked</c:if> name="gioiTinh">Nam</label>
                    <label class="checkbox-inline"><input type="radio"  value="Nữ" <c:if test="${NV.gioiTinh=='Nữ'}">checked</c:if> name="gioiTinh">Nữ</label>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Ngày Sinh:</h3>
                    <input type="text" class="form-control" name="ngaySinh" value="<f:formatDate value="${NV.ngaySinh}" pattern="dd/MM/yyyy"/>" >
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Địa Chỉ:</h3>
                    <input type="text" class="form-control" name="diaChi"  value="${NV.diaChi}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Số điện thoại:</h3>
                    <input type="tel" class="form-control" name="sdt"  value="${NV.sdt}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mật khẩu:</h3>
                    <input type="text" class="form-control" name="matKhau"  value="${NV.matKhau}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Cửa Hàng:</h3>
                    <input type="text" class="form-control" name="cuaHang" value="${NV.cuaHang.ten}">

                </div>
                <div class="form-group">
                    <h3 class="mb-2">Chức Vụ:</h3>
                    <input type="text" class="form-control" name="chucVu" value="${NV.chucVu.ten}">

                </div>
                <div class="form-group">
                    <h3 class="mb-2">Trạng thái</h3>
                    <label class="checkbox-inline"><input type="radio" value="0" <c:if test="${NV.trangThai==0}">checked</c:if> name="trangThai">Đi làm</label>
                    <label class="checkbox-inline"><input type="radio" value="1" <c:if test="${NV.trangThai==1}">checked</c:if> name="trangThai">Nghỉ làm</label>
                </div>

                <a href="/NhanVienServlet" class="btn btn-primary">Display Nhan Vien</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>

