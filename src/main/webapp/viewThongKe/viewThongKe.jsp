
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Thống kê</title>
    <style>
        .card {
            width: 350px;
            height: 150px;
            background: rgb(17, 4, 134);
            border-radius: 15px;
            display: flex;
            color: white;
            justify-content: center;
            position: relative;
            flex-direction: column;
            background: linear-gradient(215deg, rgb(139, 242, 219), rgb(175, 246, 235), rgb(239, 170, 200), rgb(225, 113, 161));
            cursor: pointer;
            transition: all 0.3s ease-in-out;
            overflow: hidden;
        }

        .card:hover {
            box-shadow: rgb(0,0,0) 5px 10px 50px ,rgb(0,0,0) -5px 0px 250px;
        }

        .time-text {
            font-size: 50px;
            margin-top: 0px;
            margin-left: 15px;
            font-weight: 600;
            color: red;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }

        .time-sub-text {
            font-size: 15px;
            margin-left: 5px;
        }

        .day-text {
            font-size: 18px;
            margin-top: 0px;
            margin-left: 15px;
            font-weight: 500;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }
        .input-container {
            width: 220px;
            position: relative;
        }

        .input {
            width: 100%;
            height: 40px;
            padding: 10px;
            transition: .2s linear;
            border: 2.5px solid black;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 2px;
        }

        .input:focus {
            outline: none;
            border: 0.5px solid black;
            box-shadow: -5px -5px 0px black;
        }

        .input-container:hover > .icon {
            animation: anim 1s linear infinite;
        }

        @keyframes anim {
            0%,
            100% {
                transform: translateY(calc(-50% - 5px)) scale(1);
            }

            50% {
                transform: translateY(calc(-50% - 5px)) scale(1.1);
            }
        }
        .shadow__btn {
            padding: 10px 20px;
            border: none;
            font-size: 17px;
            color: #fff;
            border-radius: 7px;
            letter-spacing: 4px;
            font-weight: 700;
            text-transform: uppercase;
            transition: 0.5s;
            transition-property: box-shadow;
        }

        .shadow__btn {
            background: rgb(0,140,255);
            box-shadow: 0 0 25px rgb(0,140,255);
        }

        .shadow__btn:hover {
            box-shadow: 0 0 5px rgb(0,140,255),
            0 0 25px rgb(0,140,255),
            0 0 50px rgb(0,140,255),
            0 0 100px rgb(0,140,255);
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row" style="margin-top: 20px;">
        <div class="col-sm-4">
        <div class="card">
            <p class="time-text"><span><f:formatNumber value="${DTNGAY}"  type="currency"/></span><span class="time-sub-text"></span></p>
            <p class="day-text">Doanh thu ngày</p>
        </div>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <p class="time-text"><span><f:formatNumber value="${DTTHANG}"  type="currency"/></span><span class="time-sub-text"></span></p>
                <p class="day-text">Doanh thu tháng</p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <p class="time-text"><span><f:formatNumber value="${DTNAM}"  type="currency"/></span><span class="time-sub-text"></span></p>
                <p class="day-text">Doanh thu năm</p>
            </div>
        </div>
    </div>
    <form action="/ThongKeServlet" method="post">
    <div class="row" style="margin-top: 40px;">
        <div class="col-sm-3">
        <div class="input-container">
            <input type="date" name="ngayBD" class="input" placeholder="ngày bắt đầu">
        </div>
        </div>
        <div class="col-sm-3">
        <div class="input-container">
            <input type="date" name="ngayKT" class="input" placeholder="ngày kết thúc">
        </div>
        </div>
        <button type="submit" class="shadow__btn">
            Lọc
        </button>
    </div>
    </form>
</div>
<div class="container-fluid">
<table class="table table-striped" style="margin-top: 50px;">
    <thead style="background-color: black;color: white;">
    <tr class="">
        <th class="col">ID hóa đơn</th>
        <th class="col">Tên khách hàng</th>
        <th class="col">Mã hóa đơn</th>
        <th class="col">Ngày tạo</th>
        <th class="col">Ngày thanh toán</th>
        <th class="col">Tên người nhận</th>
        <th class="col">SDT</th>
        <th class="col">Địa chỉ</th>
        <th class="col">Tình trạng</th>
        <th class="col">Thành Tiền</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hd" items="${LIST_HD}">
        <tr>
            <td>${hd[0]}</td>
            <td class="text-center">${hd[1]}</td>
            <td class="text-center">${hd[2]}</td>
            <td class="text-center"><f:formatDate value="${hd[3]}" pattern="dd/MM/yyyy"/></td>
            <td class="text-center"><f:formatDate value="${hd[4]}" pattern="dd/MM/yyyy"/></td>
            <td class="text-center">${hd[5]}</td>
            <td>${hd[6]}</td>
            <td>${hd[7]}</td>
            <td>${hd[8]==1?"Đã thanh toán":"Chưa thanh toán"}</td>
            <td class="text-center">${hd[9]}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
