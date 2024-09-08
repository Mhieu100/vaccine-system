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
              <h5 class="card-title">Danh sách địa điểm tiêm chủng</h5>
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
                <th scope="col">Số liên hệ</th>
                <th scope="col">Fanpage</th>
                <th scope="col">Email</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Website</th>
                <th scope="col">Hành động</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="location" items="${listLocation}" varStatus="status">
                <tr>
                  <td>${status.index + 1}</td>
                  <td><img src="${location.imageLink}" width="80px" alt="vaccine"></td>
                  <td class="shorten-text">${location.nameLocation}</td>
                  <td>${location.phone}</td>
                  <td class="shorten-text"><a href="${location.fanpage}">Truy cập</a></td>
                  <td class="shorten-text">${location.email}</td>
                  <td class="shorten-text">${location.address}</td>
                  <td class="shorten-text"><a href="${location.website}">Truy cập</a></td>
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
                      href="${pageContext.request.contextPath}/admin/locations/?page=${currentPage - 1}"
                      aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
              </a></li>

              <c:forEach begin="0" end="${totalPages - 1}" varStatus="loop">
                <li class="page-item"><a
                        class="${(loop.index + 1) eq currentPage ? 'active page-link' : 'page-link'}"
                        href="${pageContext.request.contextPath}/admin/locations/?page=${loop.index + 1}">
                    ${loop.index + 1} </a></li>
              </c:forEach>

              <li class="page-item"><a
                      class="${totalPages eq currentPage ? 'disabled page-link' : 'page-link'}"
                      href="${pageContext.request.contextPath}/admin/locations/?page=${currentPage + 1}"
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