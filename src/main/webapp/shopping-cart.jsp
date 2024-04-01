<%--
  Created by IntelliJ IDEA.
  User: Phanh
  Date: 22/07/2023
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shoping Cart</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>
<body class="animsition">

<!-- Header -->
<jsp:include page="header.jsp"/>

<!-- breadcrumb -->
<div class="container">
    <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
        <a href="/HomeServlet" class="stext-109 cl8 hov-cl1 trans-04">
            Home
            <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
        </a>

        <span class="stext-109 cl4">
				Shoping Cart
			</span>
    </div>
</div>


<!-- Shoping Cart -->
<div class="bg0 p-t-75 p-b-85">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                <div class="m-l-25 m-r--38 m-lr-0-xl">

                    <div class="wrap-table-shopping-cart">
                        <table class="table-shopping-cart">
                            <tr class="table_head">
                                <th class="column-1">Hình Ảnh</th>
                                <th class="column-2">Tên Sản Phẩm</th>
                                <th class="column-3">Đơn Giá</th>
                                <th class="column-4 text-center">Số lượng</th>
                                <th class="column-5">Thành Tiền</th>
                            </tr>

                            <c:forEach var="g" items="${GHCT}">
                                <form action="/UpdateGH" method="post">
                                    <tr class="table_row">

                                        <input type="hidden" name="idSP" value="${g.chiTietSP.id}">
                                        <input type="hidden" name="idGH" value="${g.gioHang.id}">
                                        <td class="column-1">
                                            <a  href="/deleteGH?idSP=${g.chiTietSP.id}&idGH=${g.gioHang.id}">
                                            <div class="how-itemcart1">
                                                <img src="images/${g.chiTietSP.hinhAnh}" alt="IMG">
                                            </div>
                                            </a>
                                        </td>
                                        <td class="column-2">${g.chiTietSP.sanPham.ten}</td>
                                        <td class="column-3">${g.chiTietSP.giaBan}</td>
                                        <td class="column-4">


                                            <div class="wrap-num-product flex-w m-l-auto m-r-0">
                                                <button type="submit" class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class="fs-16 zmdi zmdi-minus"></i>
                                                </button>

                                                <input class="mtext-104 cl3 txt-center num-product" type="number"
                                                       name="soLuong" value="${g.soLuong}">

                                                <button type="submit" class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class="fs-16 zmdi zmdi-plus"></i>
                                                </button>
                                            </div>

                                        </td>
                                        <td class="column-5">${g.donGia}</td>
                                    </tr>
                                </form>
                            </c:forEach>

                        </table>
                    </div>

                    <div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
                        <div class="flex-w flex-m m-r-20 m-tb-5">

                        </div>

                        <div class="flex-c-m stext-101 cl2 size-119 bg8 bor13 p-lr-15 trans-04 pointer m-tb-10">
                            ${TONGTIEN} VNĐ
                        </div>
                    </div>

                </div>
            </div>

            <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
                <form action="/ThanhToan" method="post">
                <div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-30 m-r-10 m-lr-0-xl p-lr-15-sm">
                    <h4 class="mtext-109 cl2 p-b-30">
                        Cart Totals
                    </h4>

                    <div class="flex-w flex-t bor12 p-b-13">
                        <div class="size-208">
								<span class="stext-110 cl2 ">
									Thành tiền:
								</span>

                        </div>

                        <div class="size-209">
								<span class="mtext-110 cl2">
                                ${TONGTIEN} VNĐ
								</span>
                        </div>
                    </div>

                    <div class="flex-w flex-t bor12 p-t-15 p-b-30">
                        <div class="size-208 w-full-ssm">
								<span class="stext-110 cl2">
									Shipping:
								</span>
                        </div>

                        <div class="size-209 p-r-18 p-r-0-sm w-full-ssm">
                            <p class="stext-111 cl6 p-t-2">
                                There are no shipping methods available. Please double check your address, or contact us
                                if you need any help.
                            </p>

                            <div class="p-t-15">
                                <div class="bor8 bg0 m-b-12">
                                    <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="tenNguoiNhan"
                                          value="${TENNN}" placeholder="Tên người nhận">
                                    <p style="color: red;">${LOI_TEN}</p>
                                </div>
                                <div class="bor8 bg0 m-b-12">
                                    <input class="stext-111 cl8 plh3 size-111 p-lr-15" type="text" name="sdt"
                                          value="${SDT}" placeholder="Số điện thoại">
                                    <p style="color: red;">${LOI_SDT}</p>
                                </div>

                                <div class="bor8 bg0 m-b-22">
                                    <textarea class="stext-111 cl8 plh3 size-111 p-lr-15" name="diaChi"
                                              placeholder="Địa chỉ">${DIACHI}</textarea>
                                    <p style="color: red;">${LOI_DCHI}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="flex-w flex-t p-t-27 p-b-33">
                        <div class="size-208">
								<span class="mtext-101 cl2">
									Tổng:
								</span>
                        </div>

                        <div class="size-209 p-t-1">
								<span class="mtext-110 cl2" style="font-weight: bolder;">
                                    ${TONGTIEN} VNĐ
								</span>
                        </div>
                    </div>

                    <button type="submit" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer ">
                        Proceed to Checkout
                    </button>
                </div>
                </form>
            </div>

        </div>
    </div>
</div>


<!-- Footer -->
<jsp:include page="footer.jsp"/>
<!-- Back to top -->
<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
</div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="vendor/parallax100/parallax100.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script>
    $(".js-select2").each(function () {
        $(this).select2({
            minimumResultsForSearch: 20,
            dropdownParent: $(this).next('.dropDownSelect2')
        });
    })
</script>
<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        $(this).css('position', 'relative');
        $(this).css('overflow', 'hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function () {
            ps.update();
        })
    });

</script>
<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<script src="vendor/sweetalert/sweetalert.min.js"></script>
<script>
    $('.js-thanhtoan').each(function(){
        $(this).on('click', function(){
            swal( "Thanh toán thành công!");
        });
    });</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>