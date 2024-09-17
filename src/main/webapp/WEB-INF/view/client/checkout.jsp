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
    <title>Hệ Thống Tiêm Chủng Thành Phố</title>
    <jsp:include page="layout/cssLink.jsp" />

</head>
<body>
    <!-- ======= Header ======= -->
    <jsp:include page="layout/header.jsp" />
    <section class="h-100 h-custom" style="background-color: #eee;">
        <div class="container h-100 py-3">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col">
                    <div class="card shopping-cart" style="border-radius: 15px;">
                        <div class="card-body">

                            <div class="row">
                                <div class="col-lg-6 px-5 py-4">

                                    <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Vắc xin tiêm chủng</h3>

                                    <div class="d-flex align-items-center mb-5">
                                        <div class="flex-shrink-0">
                                            <img src="${vaccine.image}"
                                                 class="img-fluid" style="width: 150px;" alt="Generic placeholder image">
                                        </div>
                                        <div class="flex-grow-1 ms-3">
                                            <h5 class="text-primary">${vaccine.name}</h5>
                                            <h6 style="color: #9e9e9e;">Bệnh : ${vaccine.disease}</h6>
                                            <h6 style="color: #9e9e9e;">Xuất sứ : ${vaccine.country}</h6>
                                        </div>
                                    </div>

                                    <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">
                                    <div class="d-flex justify-content-between mb-2">
                                        <h5 class="fw-bold mb-0">Tổng thanh toán:</h5>
                                        <h5 class="fw-bold mb-0"><fmt:formatNumber value="${vaccine.price}" type="number" groupingUsed="true" /> đ</h5>
                                    </div>
                                </div>
                                <div class="col-lg-6 px-5 py-4">

                                    <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Thông tin tiêm chủng</h3>

                                    <form class="mb-5">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div data-mdb-input-init class="form-outline mb-3">
                                                    <input type="text" id="name" class="form-control form-control-lg" value="${patient.user.fullName}" disabled/>
                                                    <label class="form-label" for="name">Người đăng ký</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div data-mdb-input-init class="form-outline mb-3">
                                                    <input type="text" id="phone" class="form-control form-control-lg" value="${patient.user.phone}" disabled />
                                                    <label class="form-label" for="phone">Số điện thoại liên lạc</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div data-mdb-input-init class="form-outline mb-3">
                                                    <input type="date" id="date" class="form-control form-control-lg"  />
                                                    <label class="form-label" for="date">Ngày tiêm</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div data-mdb-input-init class="form-outline mb-3">
                                                    <input type="time" id="time" class="form-control form-control-lg"  />
                                                    <label class="form-label" for="time">Giờ tiêm</label>
                                                </div>
                                            </div>
                                            <div class="col-md-12">
                                                <div data-mdb-input-init class="form-outline mb-3">
                                                    <select class="form-select" id="location" aria-label="Default select example">
                                                        <option selected>Chọn địa điểm tiêm</option>
                                                        <c:forEach items="${locations}" var="location">
                                                            <option value="${location.id}">${location.nameLocation}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <a class="btn btn-primary btn-block btn-lg" href="" >Thanh toán sau khi tiêm</a>


                                     <a class="btn btn-danger btn-block btn-lg" href="${pageContext.request.contextPath}/payment?totalPrice=${vaccine.price}&vaccineID=${vaccine.id}">Thanh toán qua tài khoản ngân hàng</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="layout/jsLink.jsp" />
    <script>
        // Set the default value of date to the current date
        const today = new Date().toISOString().split('T')[0]; // Get the current date in 'YYYY-MM-DD' format
        document.getElementById('date').value = today;

        // Optionally, set default time and datetime-local as well
        const now = new Date();
        const currentTime = now.toTimeString().slice(0, 5); // Get the current time in 'HH:MM' format
        document.getElementById('time').value = currentTime;

    </script>
</body>
</html>