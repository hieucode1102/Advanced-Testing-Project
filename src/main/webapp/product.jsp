
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product</title>
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
  <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="css/util.css">
  <link rel="stylesheet" type="text/css" href="css/main.css">
  <!--===============================================================================================-->
</head>
<body class="animsition">

<jsp:include page="header.jsp"/>



<!-- Product -->
<div class="bg0 m-t-120 p-b-140">
  <div class="container">
    <div class="p-b-10">
      <h3 class="ltext-103 cl5">
        Product Overview
      </h3>
    </div>

    <div class="flex-w flex-sb-m p-b-52">
      <div class="flex-w flex-l-m filter-tope-group m-tb-10">

      </div>

      <div class="flex-w flex-c-m m-tb-10">
        <div class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter">
          <i class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i>
          <i class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
          Filter
        </div>

        <div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
          <i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
          <i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
          Search
        </div>
      </div>

      <!-- Search product -->
      <div class="dis-none panel-search w-full p-t-10 p-b-15">
        <div class="bor8 dis-flex p-l-15">
          <button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
            <i class="zmdi zmdi-search"></i>
          </button>
          <form action="/searchSPPro">
            <input class="mtext-107 cl2 size-114 plh2 p-r-15" type="text" name="search" placeholder="Search">
          </form>
        </div>
      </div>

      <!-- Filter -->
      <div class="dis-none panel-filter w-full p-t-10">
        <div class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm">
          <div class="filter-col1 p-r-15 p-b-27">
            <div class="mtext-102 cl2 p-b-15">
              Sort By
            </div>

            <ul>
              <li class="p-b-6">
                <a href="/SortByTenProServlet" class="filter-link stext-106 trans-04">
                  Tên Sản Phẩm
                </a>
              </li>

              <li class="p-b-6">
                <a href="/SortByGiaNhoProServlet" class="filter-link stext-106 trans-04">
                  Giá: Thấp đến Cao
                </a>
              </li>

              <li class="p-b-6">
                <a href="/SortByGiaLonProServlet" class="filter-link stext-106 trans-04">
                  Giá: Cao đến Thấp
                </a>
              </li>
            </ul>
          </div>

          <div class="filter-col2 p-r-15 p-b-27">
            <div class="mtext-102 cl2 p-b-15">
              Giá
            </div>

            <ul>
              <li class="p-b-6">
                <a href="/ProductServlet" class="filter-link stext-106 trans-04 ">
                  All
                </a>
              </li>

              <li class="p-b-6">
                <a href="/LocGiaProServlet?start=0&end=50000" class="filter-link stext-106 trans-04">
                  0 VNĐ - 50.000VND
                </a>
              </li>

              <li class="p-b-6">
                <a href="/LocGiaProServlet?start=50000&end=100000" class="filter-link stext-106 trans-04">
                  50.000VND - 100.000 VNĐ
                </a>
              </li>

              <li class="p-b-6">
                <a href="/LocGiaProServlet?start=100000&end=150000" class="filter-link stext-106 trans-04">
                  100.000VND - 150.000 VNĐ
                </a>
              </li>

              <li class="p-b-6">
                <a href="/LocGiaProServlet?start=150000&end=200000" class="filter-link stext-106 trans-04">
                  150.000VND - 200.000 VNĐ
                </a>
              </li>

              <li class="p-b-6">
                <a href="/LocGiaProServlet?start=200000&end=100000000" class="filter-link stext-106 trans-04">
                  200.000++
                </a>
              </li>
            </ul>
          </div>

          <div class="filter-col3 p-r-15 p-b-27">
            <div class="mtext-102 cl2 p-b-15">
              Màu Sắc
            </div>

            <ul>
              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #222;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Đen" class="filter-link stext-106 trans-04">
                  Đen
                </a>
              </li>

              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #4272d7;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Xanh" class="filter-link stext-106 trans-04">
                  Xanh
                </a>
              </li>

              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #b3b3b3;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Xám" class="filter-link stext-106 trans-04">
                  Xám
                </a>
              </li>

              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #00ad5f;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Xanh lá" class="filter-link stext-106 trans-04">
                  Xanh lá
                </a>
              </li>

              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #fa4251;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Đỏ" class="filter-link stext-106 trans-04">
                  Đỏ
                </a>
              </li>

              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #aaa;">
										<i class="zmdi zmdi-circle-o"></i>
									</span>

                <a href="/LocMSProServlet?ms=Trắng" class="filter-link stext-106 trans-04">
                  Trắng
                </a>
              </li>
              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: #f74877;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Hồng" class="filter-link stext-106 trans-04">
                  Hồng
                </a>
              </li>
              <li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: bisque;">
										<i class="zmdi zmdi-circle"></i>
									</span>

                <a href="/LocMSProServlet?ms=Be" class="filter-link stext-106 trans-04">
                  Be
                </a>
              </li>
            </ul>
          </div>

          <div class="filter-col4 p-b-27">
            <div class="mtext-102 cl2 p-b-15">
              Danh Mục
            </div>

            <div class="flex-w p-t-4 m-r--5">
              <c:forEach var="d" items="${LIST_DM}">
                <a href="/LocDSPProServlet?dsp=${d.ten}" class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
                    ${d.ten}
                </a>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row isotope-grid">
      <c:forEach var="c" items="${LIST_CTSP}">
        <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item men" style="position: absolute; left: 49.9635%; top: 796px;">
          <!-- Block2 -->
          <input type="hidden" name="idSP" value="${c.id}">
          <div class="block2">
            <div class="block2-pic hov-img0">
              <img src="images/${c.hinhAnh}" style="width: 245px;height: 302px;" alt="IMG-PRODUCT">

              <a href="/QuickServlet?idSP=${c.id}" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
                Quick View
              </a>
            </div>

            <div class="block2-txt flex-w flex-t p-t-14">
              <div class="block2-txt-child1 flex-col-l ">
                <a href="/QuickServlet?idSP=${c.id}" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                    ${c.sanPham.ten}
                </a>

                <span class="stext-105 cl3">
									${c.giaBan} VNĐ
								</span>
              </div>

              <div class="block2-txt-child2 flex-r p-t-3">
                <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                  <img class="icon-heart1 dis-block trans-04" src="images/icons/icon-heart-01.png" alt="ICON">
                  <img class="icon-heart2 dis-block trans-04 ab-t-l" src="images/icons/icon-heart-02.png" alt="ICON">
                </a>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>



    </div>
    <!-- Load more -->
    <div class="flex-c-m flex-w w-full p-t-45">
      <a href="#" class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04">
        Load More
      </a>
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
<script src="vendor/select2/select2.min.js"></script>
<script>
  $(".js-select2").each(function(){
    $(this).select2({
      minimumResultsForSearch: 20,
      dropdownParent: $(this).next('.dropDownSelect2')
    });
  })
</script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="vendor/parallax100/parallax100.js"></script>
<script>
  $('.parallax100').parallax100();
</script>
<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<script>
  $('.gallery-lb').each(function() { // the containers for all your galleries
    $(this).magnificPopup({
      delegate: 'a', // the selector for gallery item
      type: 'image',
      gallery: {
        enabled:true
      },
      mainClass: 'mfp-fade'
    });
  });
</script>
<!--===============================================================================================-->
<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/sweetalert/sweetalert.min.js"></script>
<script>
  $('.js-addwish-b2, .js-addwish-detail').on('click', function(e){
    e.preventDefault();
  });

  $('.js-addwish-b2').each(function(){
    var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
    $(this).on('click', function(){
      swal(nameProduct, "is added to wishlist !", "success");

      $(this).addClass('js-addedwish-b2');
      $(this).off('click');
    });
  });

  $('.js-addwish-detail').each(function(){
    var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

    $(this).on('click', function(){
      swal(nameProduct, "is added to wishlist !", "success");

      $(this).addClass('js-addedwish-detail');
      $(this).off('click');
    });
  });

  /*---------------------------------------------*/

  $('.js-addcart-detail').each(function(){
    var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
    $(this).on('click', function(){
      swal(nameProduct, "is added to cart !", "success");
    });
  });

</script>
<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
  $('.js-pscroll').each(function(){
    $(this).css('position','relative');
    $(this).css('overflow','hidden');
    var ps = new PerfectScrollbar(this, {
      wheelSpeed: 1,
      scrollingThreshold: 1000,
      wheelPropagation: false,
    });

    $(window).on('resize', function(){
      ps.update();
    })
  });
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>