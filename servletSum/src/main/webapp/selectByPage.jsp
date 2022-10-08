<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>分页查询</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <div class="row">
        <table class="table table-striped table-hover table-primary">
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>生日</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>职业</th>
            </tr>

            <c:forEach var="customer" items="${requestScope.customerPage.list}">
                <tr>
                    <td>${customer.cid}</td>
                    <td>${customer.cname}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.birthday}</td>
                    <td>${customer.cellphone}</td>
                    <td>${customer.email}</td>
                    <td>${customer.profession}</td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach var="i" begin="1" end="${requestScope.customerPage.pageTotal}">
            <c:choose>
                <c:when test="${i eq requestScope.customerPage.pageIndex}">[${i}]</c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/customerServlet?method=selectByPage&pageIndex=${i}">[${i}]</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </div>
</div>

</div>
</body>
</html>
