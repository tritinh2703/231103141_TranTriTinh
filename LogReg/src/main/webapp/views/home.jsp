<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="topbar">
        <%@ include file="topbar.jsp" %>
    </div>
    <h2>Chào mừng đến trang chủ!</h2>
    <c:choose>
        <c:when test="${sessionScope.account != null}">
            <p>Xin chào, <c:out value="${sessionScope.account.fullName}" default="Không có tên" /></p>
            <p>Tài khoản: <c:out value="${sessionScope.account.userName}" default="Không có tài khoản" /></p>
            <p>Vai trò: <c:out value="${sessionScope.account.roleid}" default="0" /></p>
            <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
        </c:when>
        <c:otherwise>
            <p>Bạn chưa đăng nhập. <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
        </c:otherwise>
    </c:choose>
</body>
</html>