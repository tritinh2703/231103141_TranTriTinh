<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="topbar">
    <c:choose>
        <c:when test="${sessionScope.account == null}">
            <div class="col-sm-6">
                <ul class="list-inline right-topbar pull-right">
                    <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a> | <a href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
                    <li><i class="search fa fa-search search-button"></i></li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-sm-6">
                <ul class="list-inline right-topbar pull-right">
                    <li><a href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.account.fullName}</a> | <a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a></li>
                    <li><i class="search fa fa-search search-button"></i></li>
                </ul>
            </div>
        </c:otherwise>
    </c:choose>
</div>