<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Update Chức Vụ</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="/updateMS" method="post" >
                <h1 class="mt-5 mb-5 text-center">Sửa Thông Tin Màu Sắc</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Màu Sắc:</h3>
                    <input type="text" class="form-control" name="id" value="${MS.id}" placeholder="Enter ID Mau Sac">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mã Màu Sắc:</h3>
                    <input type="text" class="form-control" name="ma" value="${MS.ma}" placeholder="Enter Ma Mau Sac">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Màu Sắc:</h3>
                    <input type="text" class="form-control" name="ten" value="${MS.ten}"  placeholder="Enter Ten Mau Sac">
                </div>
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="reset" class="btn btn-danger">Cancel</button>
                <a href="/MauSacServlet" class="btn btn-primary">Display Chuc Vu</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>
