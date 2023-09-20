<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>verifyCode</title>
</head>
<body>
<form action="/servlet/loginNote">
    账号：<input type="text" name="username" value="${cookie.username.value}"><br>
    密码：<input type="password" name="password" value="123"><br>
    验证码：<input type="text" name="userCode"> <img src="/servlet/verifyCodeNote" id="imgCode"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
