<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Add Khách Hàng</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="addKH" method="post" >
                <h1 class="mt-5 mb-5 text-center">Thêm Khách Hàng</h1>
                <div class="form-group">
                    <h3 class="mb-2">Mã Khách Hàng:</h3>
                    <input type="text" class="form-control" name="ma" placeholder="Enter Ma Khach Hang" required>
                    <p style="color:red;">${LOI_MA}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Khách Hàng:</h3>
                    <input type="text" class="form-control" name="ten"  placeholder="Enter Ten Khach Hang" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Đệm:</h3>
                    <input type="text" class="form-control" name="tenDem"  placeholder="Enter Ten Dem Khach Hang" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Họ:</h3>
                    <input type="text" class="form-control" name="ho"  placeholder="Enter Ho Khach Hang" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Ngày Sinh:</h3>
                    <input type="date" class="form-control" name="ngaySinh" value="dd/MM/yyyy"  placeholder="Enter Ngay Sinh" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Số điện thoại:</h3>
                    <input type="tel" class="form-control" name="sdt"  placeholder="Enter So Dien Thoai" required>
                    <p style="color: red">${LOI_SDT}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Địa Chỉ:</h3>
                    <input type="text" class="form-control" name="diaChi"  placeholder="Enter Dia Chi" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Thành Phố:</h3>
                    <input type="text" class="form-control" name="thanhPho"  placeholder="Enter Thanh Pho" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Quốc Gia:</h3>
                    <input type="text" class="form-control" name="quocGia"  placeholder="Enter Quoc Gia" required>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mật khẩu:</h3>
                    <input type="text" class="form-control" name="matKhau"  placeholder="Enter Mat Khau" required>
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

