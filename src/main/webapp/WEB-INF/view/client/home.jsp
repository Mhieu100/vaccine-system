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
    <main class="mt-5">
        <section style="background-color: #eee;">
            <div class="text-center container py-5">
                <h4 class="mt-4 mb-5"><strong>Bestsellers</strong></h4>

                <div class="row">
                    <c:forEach items="${dsVaccine}" var="vaccine">
                    <div class="col-lg-3 col-md-6 mb-4">
                        <div class="card">
                            <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                 data-mdb-ripple-color="light">
                                <img src="${vaccine.image}"
                                     class="w-100" />
                                <a href="#!">
                                    <div class="mask">
                                        <div class="d-flex justify-content-start align-items-end h-100">
                                            <h5><span class="badge bg-primary ms-2">${vaccine.country}</span></h5>
                                            <h5><span class="badge bg-primary ms-2">Số lượng : ${vaccine.quantity}</span></h5>
                                        </div>
                                    </div>
                                    <div class="hover-overlay">
                                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                    </div>
                                </a>
                            </div>
                            <div class="card-body">
                                <a href="" class="text-reset">
                                    <h5 class="card-title mb-3">${vaccine.name}</h5>
                                </a>
                                <a href="" class="text-reset">
                                    <p>${vaccine.disease}</p>
                                </a>
                                <h6 class="mb-3"><fmt:formatNumber value="${vaccine.price}" type="number" groupingUsed="true" /> đ</h6>
                                <a class="btn btn-success" href="${pageContext.request.contextPath}/checkout/${vaccine.id}">Đặt lịch tiêm</a>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    </main>
    <jsp:include page="layout/jsLink.jsp" />
</body>
</html>