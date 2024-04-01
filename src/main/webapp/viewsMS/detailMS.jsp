<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Detail Màu Sắc</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="" >
                <h1 class="mt-5 mb-5 text-center">Thông Tin Màu Sắc</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Màu Sắc:</h3>
                    <input type="text" class="form-control" name="id" value="${MS.id}" placeholder="Enter ID Chuc Vu">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mã Màu Sắc:</h3>
                    <input type="text" class="form-control" name="ma" value="${MS.ma}" placeholder="Enter Ma Chuc Vu">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Màu Sắc:</h3>
                    <input type="text" class="form-control" name="ten" value="${MS.ten}"  placeholder="Enter Ten Chuc Vu">
                </div>
                <a href="/MauSacServlet" class="btn btn-primary">Display Mau Sac</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>
