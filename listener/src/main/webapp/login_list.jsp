<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>login_list</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/login.html"><h1>登录</h1></a>
<h1>当前用户</h1>
<c:if test="${sessionScope.user!=null}">
    <h2>欢迎${sessionScope.user.username}访问网站<a href="${pageContext.request.contextPath}/loginServlet?op=out">退出</a></h2>
</c:if>
<br>

<h1>用户列表</h1>
<c:if test="${not empty applicationScope.map}">
    <ul>
        <c:forEach items="${applicationScope.map}" var="entry">
            <li>
                ${entry.key}
            </li>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>
