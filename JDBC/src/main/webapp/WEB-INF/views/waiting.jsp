<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chào mừng</title>
</head>
<body>
    <h2>Chào mừng bạn đã đăng nhập thành công!</h2>
    <c:if test="${not empty sessionScope.account}">
        <p>Xin chào, ${sessionScope.account.fullName}!</p>
    </c:if>
</body>
</html>