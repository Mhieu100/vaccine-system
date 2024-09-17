<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Quản trị hệ thống</title>
  <jsp:include page="../layout/cssLink.jsp" />
</head>
<body>
  <main>
    <div class="container">

      <section class="section error-404 min-vh-100 d-flex flex-column align-items-center justify-content-center">
        <h1>403</h1>
        <h2>Bạn không có quyền truy cập đến trang này.</h2>
        <button class="btn" onclick="goBack()">Trở lại</button>

      </section>

    </div>
  </main><!-- End #main -->
  <script>
    function goBack() {
      window.history.back();
    }
  </script>
  <jsp:include page="../layout/jsLink.jsp" />

</body>

</html>