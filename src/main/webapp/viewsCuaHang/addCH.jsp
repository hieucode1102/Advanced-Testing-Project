<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Add Cửa Hàng</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="/addCH" method="post" >
                <h1 class="mt-5 mb-5 text-center">Thêm Cửa Hàng</h1>
                <div class="form-group">
                    <h3 class="mb-2">Mã Cửa Hàng:</h3>
                    <input type="text" class="form-control" name="ma" placeholder="Enter Ma Cua Hang">
                    <p style="color:red;">${LOI_MA}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Cửa Hàng:</h3>
                    <input type="text" class="form-control" name="ten"  placeholder="Enter Ten Cua Hang">
                    <p style="color:red;">${LOI_TEN}</p>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Địa Chỉ:</h3>
                    <input type="text" class="form-control" name="diaChi"  placeholder="Enter Dia Chi">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Thành Phố:</h3>
                    <input type="text" class="form-control" name="thanhPho"  placeholder="Enter Thanh Pho">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Quốc Gia:</h3>
                    <input type="text" class="form-control" name="quocGia"  placeholder="Enter Quoc Gia">
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="reset" class="btn btn-danger">Cancel</button>
                <a href="/CuaHangServlet" class="btn btn-primary">Display Cua Hang</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>

