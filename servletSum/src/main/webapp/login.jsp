<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body>
<div class="css_test">
    测试css是否生效
</div>
<form action="${pageContext.request.contextPath}/userServlet" method="post">
    <input type="hidden" name="method" value="login">
    用户名：<input type="text" name="name" value="kace"><br>
    密码：<input type="password" name="password" value="123"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
