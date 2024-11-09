<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <section class="mt-5" style="background-color: #eee;">
        <div class="container py-5">
            <div class="row">
                <div class="col-lg-4">
                    <div class="card mb-4">
                        <div class="card-body text-center">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                                 class="rounded-circle img-fluid" style="width: 150px;">
                            <h5 class="my-3">${patient.user.fullName}</h5>
                            <p class="text-muted mb-1">${patient.user.role.value}</p>
                            <p class="text-muted mb-4">${patient.user.address}</p>
                            <div class="d-flex justify-content-center mb-2">
                                <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary">Follow</button>
                                <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-primary ms-1">Message</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Họ tên</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${patient.user.fullName}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Email</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${patient.user.email}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Giới tính</p>
                                </div>
                                <div class="col-sm-9 d-flex gap-3">
                                    <!-- Default radio -->
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="gender" id="nam" <c:if test="${patient.user.gender == 0}">checked</c:if>/>
                                        <label class="form-check-label" for="nam"> Nam </label>
                                    </div>

                                    <!-- Default checked radio -->
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="gender" id="nu" <c:if test="${patient.user.gender == 1}">checked</c:if>/>
                                        <label class="form-check-label" for="nu"> Nữ </label>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Số điện thoại</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${patient.user.phone}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">CCCD</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${patient.idCard}</p>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <p class="mb-0">Địa chỉ</p>
                                </div>
                                <div class="col-sm-9">
                                    <p class="text-muted mb-0">${patient.user.address}</p>
                                </div>
                            </div>
                            <div class="text-center mt-4">
                                <button type="submit" class="btn btn-primary">Cập nhật hồ sơ</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="layout/jsLink.jsp" />
</body>
</html>