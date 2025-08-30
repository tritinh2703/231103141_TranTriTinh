<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <form action="login" method="post">
        <h2>Đăng nhập</h2>
        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>
        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Tài khoản" name="username" class="form-control">
                </div>
            </label>
        </section>
        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
                </div>
            </label>
        </section>
        <section>
            <label class="checkbox">
                <input type="checkbox" name="remember"> Nhớ tài khoản
            </label>
        </section>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
        <p class="register-link">
            Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký ngay</a>
        </p>
    </form>
</body>
</html>