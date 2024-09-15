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

  <main>
    <div class="container">
      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Đăng nhập hệ thống</h5>
                  </div>
                  <form class="row g-3 needs-validation" method="post" action="/login">
                    <div class="col-12">
                      <label for="email" class="form-label">Email</label>
                      <div class="input-group has-validation">
                        <input type="email" name="username" class="form-control" id="email" required>
                        <div class="invalid-feedback">Email không hợp lệ</div>
                      </div>
                    </div>

                    <div class="col-12">
                      <label for="password" class="form-label">Mật khẩu</label>
                      <input type="password" name="password" class="form-control" id="password" required>
                      <div class="invalid-feedback">Vui lòng nhập mật khẩu</div>
                    </div>           
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Đặng nhập</button>
                    </div>
                    <div class="col-12">
                      <p class="small mb-0">Chưa có tài khoản? <a href="/register">Tạo ngay</a></p>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main>
  <jsp:include page="../../layout/jsLink.jsp" />
</body>

</html>