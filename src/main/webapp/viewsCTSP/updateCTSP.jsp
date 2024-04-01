<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Add Chi Tiết Sản Phẩm</title>
</head>
<body>
<div class="container">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <form action="/updateCTSP" method="post" >
                <h1 class="mt-5 mb-5 text-center">Sửa Thông Tin Chi Tiết Sản Phẩm</h1>
                <input type="hidden" name="id" value="${C.id}">
                <div class="form-group">
                    <h3 class="mb-2">Tên Sản Phẩm:</h3>
                    <select class="form-control" name="sanPham.id" required>
                        <c:forEach var="sp" items="${LIST_SP}">
                            <option value="${sp.id}" <c:if test="${sp.id==C.sanPham.id}">selected</c:if>>${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">NSX:</h3>
                    <select class="form-control" name="nsx.id" required>
                        <c:forEach var="n" items="${LIST_NSX}">
                            <option value="${n.id}" <c:if test="${n.id==C.nsx.id}">selected</c:if>>${n.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Màu Sắc:</h3>
                    <select class="form-control" name="mauSac.id" required>
                        <c:forEach var="ms" items="${LIST_MS}">
                            <option value="${ms.id}" <c:if test="${ms.id==C.mauSac.id}">selected</c:if>>${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Dòng SP:</h3>
                    <select class="form-control" name="dongSP.id" required>
                        <c:forEach var="d" items="${LIST_DSP}">
                            <option value="${d.id}" <c:if test="${d.id==C.dongSP.id}">selected</c:if>>${d.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Năm BH:</h3>
                    <input type="number" class="form-control" min="0" name="namBH" value="${C.namBH}" placeholder="Enter Nam BH">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Mô tả:</h3>
                    <textarea name="moTa" class="form-control" placeholder="Enter moTa">${C.moTa}</textarea>
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Số lượng tồn:</h3>
                    <input type="number" class="form-control" min="1" name="slt" value="${C.slt}"  placeholder="Enter slt">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Giá nhập:</h3>
                    <input type="number" min="1" class="form-control" name="giaNhap" value="${C.giaNhap}"  placeholder="Enter Gia Nhap">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Giá Bán:</h3>
                    <input type="number" class="form-control" min="1" name="giaBan" value="${C.giaBan}" placeholder="Enter Gia Ban">
                </div>
                <div class="form-group">
                    <h3 class="mb-2">Hình ảnh:</h3>
                    <input type="file" class="form-control" name="hinhAnh" value="${C.hinhAnh}" placeholder="Enter Hinh Anh">
                </div>
                <p style="margin-bottom: 10px;margin-top: 10px;color: red">${LOI_TRUNG}</p>
                <button type="submit" class="btn btn-success">Submit</button>
                <button type="reset" class="btn btn-danger">Cancel</button>
                <a href="/ChiTietSPServlet" class="btn btn-primary">Display CTSP</a>

            </form>

        </div>
    </div>
</div>
</body>
</html>

