<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${sessionScope.account == null}">
        <a href="<c:url value='/login'/>">Đăng nhập</a> |
        <a href="<c:url value='/register'/>">Đăng ký</a>
    </c:when>
    <c:otherwise>
        <span>Chào mừng, ${sessionScope.account.fullName}!</span> |
        <a href="<c:url value='/logout'/>">Đăng Xuất</a>
    </c:otherwise>
</c:choose>