<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>footer</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script><%--用于下拉菜单--%>
    <script src="js/bootstrap.min.js"></script>
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
