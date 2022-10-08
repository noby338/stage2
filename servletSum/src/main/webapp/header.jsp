<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Header</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<div class="row">
    <div class="col-md-3">
        <a href="${pageContext.request.contextPath}/index.jsp" class="h2">首页</a>
    </div>
    <div class="col-md-3">
    </div>
    <div class="col-md-3">
    </div>
    <div class="col-md-3">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                欢迎你:<b>${sessionScope.user.name}</b><a href="${pageContext.request.contextPath}/userServlet?method=logout">[注销]</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login.jsp">[登录]</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
