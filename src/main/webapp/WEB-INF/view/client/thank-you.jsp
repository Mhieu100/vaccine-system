<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hoàn Thành Đăng Ký Tiêm Chủng</title>
    <jsp:include page="layout/cssLink.jsp" />

</head>
<body>
<!-- ======= Header ======= -->
<jsp:include page="layout/header.jsp" />
<%--<p>${message}</p>--%>
<main class="container" style="margin-top: 100px">
    <div class="card">
        <div class="card-body mx-4">
            <div class="container">
                <p class="my-3" style="font-size: 30px; text-align: center; text-transform: uppercase">Bạn đã hoàn thành đăng ký tiểm chủng</p>
                <div class="row">
                    <div class="col-xl-10">
                        <p>Người đăng ký</p>
                    </div>
                    <div class="col-xl-2">
                        <p class="float-end">${patient.user.fullName}
                        </p>
                    </div>
                    <hr>
                    <div class="col-xl-10">
                        <p>Số liên hệ</p>
                    </div>
                    <div class="col-xl-2">
                        <p class="float-end">+ ${patient.user.phone}
                        </p>
                    </div>
                    <hr>
                    <div class="col-xl-6">
                        <p>Phương thức thanh toán</p>
                    </div>
                    <div class="col-xl-6">
                        <p class="float-end">Thanh toán tài khỏan ngân hàng (<span class="text-success">${message}</span>)</p>
                    </div>
                    <hr>
                    <div class="col-lg-6 py-2">
                        <div class="d-flex align-items-center mb-5">
                            <div class="flex-shrink-0">
                                <img src="${vaccine.image}"
                                     class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                            </div>
                            <div class="flex-grow-1 ms-3 ">
                                <h5 class="text-primary">Vắn xin : ${vaccine.name}</h5>
                                <h6 style="color: #9e9e9e;">Bệnh : ${vaccine.disease}</h6>
                                <h6 style="color: #9e9e9e;">Xuất sứ : ${vaccine.country}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 py-2">
                        <div class="d-flex align-items-center mb-5">
                            <div class="flex-grow-1 ms-3">
                                <h5 class="text-primary">Địa điểm : Trung tâm tiêm chủng VNVC</h5>
                                <h6 style="color: #9e9e9e;">Giờ : 11:30 AM</h6>
                                <h6 style="color: #9e9e9e;">Ngày : 20/11/2024</h6>
                            </div>
                        </div>
                    </div>
                    <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">
                    <div class="d-flex justify-content-between mb-2">
                        <h5 class="fw-bold mb-0">Tổng thanh toán:</h5>
                        <h5 class="fw-bold mb-0"><fmt:formatNumber value="${vaccine.price}" type="number" groupingUsed="true" /> đ</h5>
                    </div>
                    <a href="/home" class="btn btn-success my-3"> < Quay lại trang chủ</a>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="layout/jsLink.jsp" />
</body>
</html>