<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Detail Dòng SP</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="" >
                <h1 class="mt-5 mb-5 text-center">Thông Tin Dòng Sản Phẩm</h1>
                <div class="form-group">
                    <h3 class="mb-2">ID Dòng SP:</h3>
                    <input type="text" class="form-control" name="id" value="${DSP.id}" >
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mã Dòng SP:</h3>
                    <input type="text" class="form-control" name="ma" value="${DSP.ma}" >
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Tên Dòng SP:</h3>
                    <input type="text" class="form-control" name="ten" value="${DSP.ten}"  >
                </div>
                <a href="/DongSPServlet" class="btn btn-primary">Display Dong SP</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>
