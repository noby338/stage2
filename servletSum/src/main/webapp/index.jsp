<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <div class="row">
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/customerServlet?method=selectAll">所有用户信息</a>
        </div>
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/customerServlet?method=selectByPage">分页查询</a>
        </div>
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/customerServlet?method=selectByFilter">条件查询所有用户</a>
        </div>
        <div class="col-md-3">
            <a href="${pageContext.request.contextPath}/selectByFilterAjax.jsp">异步条件查询所有用户</a>
        </div>
    </div>
</div>
</body>
</html>