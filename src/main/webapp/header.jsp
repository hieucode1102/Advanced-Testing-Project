
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <!-- Header desktop -->
    <div class="container-menu-desktop">
        <div class="wrap-menu-desktop">
            <nav class="limiter-menu-desktop container">

                <!-- Logo desktop -->
                <a href="/HomeServlet" class="logo">
                    <img src="images/STORE%20(2).png" alt="IMG-LOGO">
                </a>

                <!-- Menu desktop -->
                <div class="menu-desktop">
                    <ul class="main-menu">
                        <li class="active-menu">
                            <a href="/HomeServlet">Home</a>
                        </li>

                        <li>
                            <a href="/ProductServlet">Shop</a>
                        </li>

                        <li class="label1" data-label1="hot">
                            <a href="shopping-cart.jsp">Features</a>
                        </li>

                        <li>
                            <a href="/LichSuServlet">Hóa đơn</a>
                        </li>

                        <li>
                            <a href="/HomeServlet">About</a>
                            <ul class="sub-menu">
                                <li><a href="/ChucVuServlet">Quản lý chức vụ</a></li>
                                <li><a href="/MauSacServlet">Quản lý màu sắc</a></li>
                                <li><a href="/NSXServlet">Quản lý NSX</a></li>
                                <li><a href="/DongSPServlet">Quản lý dòng SP</a></li>
                                <li><a href="/CuaHangServlet">Quản lý cửa hàng</a></li>
                                <li><a href="/NhanVienServlet">Quản lý nhân viên</a></li>
                                <li><a href="KhachHangServlet">Quản lý khách hàng</a></li>
                                <li><a href="/SanPhamServlet">Quản lý sản phẩm</a></li>
                                <li><a href="/ChiTietSPServlet">Quản lý chi tiết sản  phẩm</a></li>
                                <li><a href="/ThongKeServlet">Thống kê doanh thu</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="/concat.jsp">Contact</a>
                        </li>
                    </ul>
                </div>

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>

                    <a href="/GioHangServlet" class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti " data-notify="${SLSP}">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </a>

                    <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
                        <i class="zmdi zmdi-favorite-outline"></i>
                    </a>
                    <a href="/LoginServlet" class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 " >
                        <i class="zmdi zmdi-account-circle"></i>
                    </a>
                    <a href="/LogoutServlet" onclick="return confirm('Bạn có muốn đăng xuất không?')">${USER}</a>
                </div>
            </nav>
        </div>
    </div>

    <!-- Header Mobile -->
    <div class="wrap-header-mobile">
        <!-- Logo moblie -->
        <div class="logo-mobile">
            <a href="/HomeServlet"><img src="images/STORE%20(2).png" alt="IMG-LOGO"></a>
        </div>

        <!-- Icon header -->
        <div class="wrap-icon-header flex-w flex-r-m m-r-15">
            <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                <i class="zmdi zmdi-search"></i>
            </div>

            <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="2">
                <i class="zmdi zmdi-shopping-cart"></i>
            </div>

            <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti" data-notify="0">
                <i class="zmdi zmdi-favorite-outline"></i>
            </a>
        </div>

        <!-- Button show menu -->
        <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box">
					<span class="hamburger-inner"></span>
				</span>
        </div>
    </div>


    <!-- Menu Mobile -->
    <div class="menu-mobile">
        <ul class="main-menu-m">
            <li>
                <a href="/">Home</a>
                <span class="arrow-main-menu-m">
						<i class="fa fa-angle-right" aria-hidden="true"></i>
					</span>
            </li>

            <li>
                <a href="product.jsp">Shop</a>
            </li>

            <li>
                <a href="shoping-cart.jsp" class="label1 rs1" data-label1="hot">Features</a>
            </li>

            <li>
                <a href="#">Blog</a>
            </li>

            <li>
                <a href="#">About</a>
            </li>

            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </div>

    <!-- Modal Search -->
    <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
        <div class="container-search-header">
            <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
                <img src="images/icons/icon-close2.png" alt="CLOSE">
            </button>

            <form action="/searchSP" method="get" class="wrap-search-header flex-w p-l-15">
                <button class="flex-c-m trans-04">
                    <i class="zmdi zmdi-search"></i>
                </button>
                <input class="plh3" type="text" name="search" placeholder="Search...">
            </form>
        </div>
    </div>
</header>
