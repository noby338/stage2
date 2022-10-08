<%--
  Created by IntelliJ IDEA.
  User: priv.mall.noby
  Date: 2022/3/23
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSP&EL&JSTL_note</title>
</head>
<body>
Hello jsp
<%--执行java代码--%>
<%
    System.out.println("Hello java");
%>

<%--el表达式：用来获取来自servlet中request域中的键值对--%>
${status}
<%--jstl if--%>
<c:if test="${status==1}">
    <h1>启用</h1>
</c:if>
<c:if test="${status!=1}">
    <h1>禁用</h1>
</c:if>

<%--jstl forEach--%>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
    </c:forEach>

</table>


<%--jstl for--%>
<c:forEach begin="1" end="10" step="1" var="i">
    <a href="#">${i}</a>
</c:forEach>
</body>
</html>
