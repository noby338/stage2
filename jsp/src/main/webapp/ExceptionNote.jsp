<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %><%--错误跳转的目标页面必须使用isErrorPage="true"属性--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是错误跳转的目标页面</h1>
<%out.write(exception.getMessage());%>
</body>
</html>
