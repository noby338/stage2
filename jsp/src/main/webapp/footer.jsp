<%--这是一个异步的复用页面，直接调用该页面，无需先接收servlet转发--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer</title>
    <script>
        $(function () {
            $.get("HeaderAndFooterServlet",
            {"method":"getFooter"},
            function (result) {
                $("#footer").append(result);
            })
        })
    </script>
</head>

<body>
<div id="footer"></div>
</body>
</html>
