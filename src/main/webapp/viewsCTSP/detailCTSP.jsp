<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Thông tin Chi Tiết Sản Phẩm</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="" >
                <h1 class="mt-5 mb-5 text-center">Thông Tin Chi Tiết Sản Phẩm</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Chi Tiết Sản Phẩm:</h3>
                    <input type="text" class="form-control" value="${CT.id}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Sản Phẩm:</h3>
                    <input type="text" class="form-control" value="${CT.sanPham.ten}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">NSX:</h3>
                    <input type="text" class="form-control" value="${CT.nsx.ten}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Màu Sắc:</h3>
                    <input type="text" class="form-control" value="${CT.mauSac.ten}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Dòng SP:</h3>
                    <input type="text" class="form-control" value="${CT.dongSP.ten}">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Năm BH:</h3>
                    <input type="text" class="form-control" min="0" name="namBH" value="${CT.namBH}" placeholder="Enter Nam BH">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mô tả:</h3>
                    <textarea name="moTa" class="form-control"  placeholder="Enter moTa">${CT.moTa}</textarea>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Số lượng tồn:</h3>
                    <input type="text" class="form-control" min="1" name="slt" value="${CT.slt}"  placeholder="Enter slt">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Giá nhập:</h3>
                    <input type="text" min="1" class="form-control" name="giaNhap" value="${CT.giaNhap}"  placeholder="Enter Gia Nhap">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Giá Bán:</h3>
                    <input type="text" class="form-control" min="1" name="giaBan" value="${CT.giaBan}" placeholder="Enter Gia Ban">
                </div>
                <p style="margin-bottom: 10px;margin-top: 10px;color: red">${LOI_TRUNG}</p>
                <a href="/ChiTietSPServlet" class="btn btn-primary">Display CTSP</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>

