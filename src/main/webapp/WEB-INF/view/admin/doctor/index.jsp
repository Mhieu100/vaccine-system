<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Quản trị hệ thống</title>
  <jsp:include page="../../layout/cssLink.jsp" />
</head>
<body>
  <!-- ======= Header ======= -->
  <jsp:include page="../../layout/header.jsp" />
  <!-- ======= Sidebar ======= -->
  <jsp:include page="../../layout/sidebar.jsp" />

  <!-- ======= Main ======= -->
  <main id="main" class="main">
    <section class="section dashboard">
      <div class="row">
        <div class="card">
          <div class="card-body">
            <div class="d-flex justify-content-between align-items-center">
              <h5 class="card-title">Danh sách bác sĩ</h5>
              <div class="d-flex gap-2 align-items-center">
                <div class="search-bar">
                  <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                  </form>
                </div>
                <a class="btn btn-sm btn-success">Thêm</a>
              </div>
            </div>
            <table class="table table-hover table-bordered">
              <thead>
              <tr>
                <th scope="col">STT</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Tên</th>
                <th scope="col">Lương</th>
                <th scope="col">Chuyên ngành</th>
                <th scope="col">Mã nhân viên</th>
                <th scope="col">Năm kinh nghiệm</th>
                <th scope="col">Hành động</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="doctor" items="${listDoctor}" varStatus="status">
                <tr>
                  <td>${status.index + 1}</td>
                  <td><img src="https://www.svgrepo.com/show/452030/avatar-default.svg" width="25px" class="rounded-circle" alt="avatar"></td>
                  <td>${doctor.employee.user.fullName}</td>
                  <td><fmt:formatNumber
                          value="${doctor.employee.salary}" type="number" groupingUsed="true" /> đ</td>
                  <td>${doctor.employee.department} năm</td>
                  <td>${doctor.licenseNumber}</td>
                  <td>${doctor.yearsOfExperience} năm</td>

                  <td>
                    <button type="button" class="btn btn-sm  btn-primary">Sửa</button>
                    <button type="button" class="btn btn-sm btn-danger">Xóa</button>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            <ul class="pagination">
              <li class="page-item"><a
                      class="${1 eq currentPage ? 'disabled page-link' : 'page-link'}"
                      href="${pageContext.request.contextPath}/admin/doctors/?page=${currentPage - 1}"
                      aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
              </a></li>

              <c:forEach begin="0" end="${totalPages - 1}" varStatus="loop">
                <li class="page-item"><a
                        class="${(loop.index + 1) eq currentPage ? 'active page-link' : 'page-link'}"
                        href="${pageContext.request.contextPath}/admin/doctors/?page=${loop.index + 1}">
                    ${loop.index + 1} </a></li>
              </c:forEach>

              <li class="page-item"><a
                      class="${totalPages eq currentPage ? 'disabled page-link' : 'page-link'}"
                      href="${pageContext.request.contextPath}/admin/doctors/?page=${currentPage + 1}"
                      aria-label="Next"> <span aria-hidden="true">&raquo;</span>
              </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </section>
  </main>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>
  <jsp:include page="../../layout/jsLink.jsp" />
</body>

</html>