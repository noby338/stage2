<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>条件查询</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://fastly.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <form action="${pageContext.request.contextPath}/customerServlet">
        <input type="hidden" name="method" value="selectByFilter">
        <div class="row">
            <div class="col-md-4">cid:<input type="text" name="cid" id="cid"></div>
            <div class="col-md-4">cname:<input type="text" name="cname" id="cname" value="${cname}"></div>
        </div>
        <div class="row">
            <div class="col-md-4">
                职业：
                <select name="profession" id="profession">
                    <option value="" ${empty requestScope.customer.profession}>-------</option>
                    <option value="java" <c:if test="${requestScope.customer.profession eq 'java'}">selected="selected"</c:if>>java</option>
                    <option value="c++" <c:if test= "${requestScope.customer.profession eq 'c++'}">selected="selected"</c:if>>c++</option>
                    <option value="go" <c:if test="${requestScope.customer.profession eq 'go'}">selected="selected"</c:if>>go</option>
                    <option value="python" <c:if test="${requestScope.customer.profession eq 'python'}">selected="selected"</c:if>>python</option>
                </select>
            </div>
            <div class="col-md-4">
                邮箱：
                <select name="email" id="email">
                    <option value="" ${empty requestScope.customer.email}>-------</option>
                    <option value="qq.com" <c:if test="${requestScope.customer.email == 'qq.com'}">selected="selected"</c:if>>QQ邮箱</option>
                    <option value="gmail.com" <c:if test="${requestScope.customer.email == 'gmail.com'}">selected="selected"</c:if>>谷歌邮箱</option>
                    <option value="163.com" <c:if test="${requestScope.customer.email == '163.com'}">selected="selected"</c:if>>网易邮箱</option>
                </select>
            </div>
            <%--            <div class="col-md-4">--%>
            <%--                生日范围：<input type="date" name="date_low">---%>
            <%--                <input type="date" name="date_high">--%>
            <%--            </div>--%>
            <div class="col-md-4">
                性别：
                <select name="gender" id="gender">
                    <option value="" ${empty requestScope.customer.gender}>-------</option>
                    <option value="男" <c:if test="${requestScope.customer.gender == '男'}">selected="selected"</c:if>>男</option>
                    <option value="女" <c:if test="${requestScope.customer.gender == '女'}">selected="selected"</c:if>>女</option>
                </select>
            </div>

        </div>
        <div class="row">
            <div class="col-md-4">
                <input class="btn btn-success btn-sm" type="submit" name="res_btn" id="res_btn" value="查询">
            </div>
        </div>
    </form>

    <div class="row">
        <table class="table table-striped table-hover table-primary">
            <!--
                        table           对表格做了基础的处理
                        table-striped   带条纹表格
                        table-bordered  带边框的表格
                        table-hover     添加鼠标悬停效果
                        table-dark      表格颜色
                    -->
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>生日</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>职业</th>
                <th>操作</th>
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
                    <td>
                        <a href="${pageContext.request.contextPath}/#">编辑</a>
                        <a href="${pageContext.request.contextPath}/customerServlet?method=deleteCustomer&delCid=${customer.cid}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row text-center">
        <c:choose>
            <c:when test="${requestScope.customerPage.pageIndex == requestScope.customerPage.pageStart}">
                上一页
            </c:when>
            <c:otherwise>
                <a class="btn" href="${pageContext.request.contextPath}/customerServlet?method=selectByFilter&cid=${requestScope.customer.cid}&cname=${requestScope.customer.cname}&profession=${requestScope.customer.profession}&gender=${requestScope.customer.gender}&email=${requestScope.customer.email}&pageIndex=${requestScope.customerPage.pageIndex-1}">上一页</a>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${requestScope.customerPage.pageStart}" end="${requestScope.customerPage.pageEnd}">
            <c:choose>
                <c:when test="${i == requestScope.customerPage.pageIndex}">
                    <div class="btn btn-primary">${i}</div>
                </c:when>
                <c:otherwise>
                    <a class="btn" href="${pageContext.request.contextPath}/customerServlet?method=selectByFilter&cid=${requestScope.customer.cid}&cname=${requestScope.customer.cname}&profession=${requestScope.customer.profession}&gender=${requestScope.customer.gender}&email=${requestScope.customer.email}&pageIndex=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${requestScope.customerPage.pageIndex == requestScope.customerPage.pageEnd}">
                下一页
            </c:when>
            <c:otherwise>
                <a class="btn" href="${pageContext.request.contextPath}/customerServlet?method=selectByFilter&cid=${requestScope.customer.cid}&cname=${requestScope.customer.cname}&profession=${requestScope.customer.profession}&gender=${requestScope.customer.gender}&email=${requestScope.customer.email}&pageIndex=${requestScope.customerPage.pageIndex+1}">下一页</a>
            </c:otherwise>
        </c:choose>
        第${requestScope.customerPage.pageIndex}页/共${requestScope.customerPage.pageTotal}页
    </div>
</div>
</body>
</html>
