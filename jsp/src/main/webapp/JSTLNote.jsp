<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--/jstl/core为jstl核心--%>
<%--/jstl/function为el函数库--%>

<html>
<head>
    <title>JSTLNote</title>
</head>
<body>
<hr>
<%--通过jstl实现条件判断及循环--%>
<%--模拟来自servlet的request域--%>
<%
    String[] names = {"noby", "kace", "july"};
    request.setAttribute("names", names);
%>

<%--条件判断语句--%>
<c:if test="${not empty names}">
    <%--增强for循环语句--%>
    <c:forEach var="name" items="${names}">
        ${name}
    </c:forEach>
</c:if>
<hr>

<%--for循环--%>
<c:forEach var="i" begin="0" end="2" step="1">
    ${names[i]}
</c:forEach>

<hr>
<%--赋值语句--%>
<c:set var="score" value="56"/>
<%--删除域中属性--%>
<%--<c:remove var="score" scope="page"/>--%>
<%--out输出语句--%>
<c:out value="${score}"/><br/>

<hr>
<%--选择语句--%>
<c:choose>
    <c:when test="${100 >= score and score > 90}">优秀</c:when>
    <c:when test="${90 >= score  and score > 70}">良好</c:when>
    <c:when test="${70 >= score  and score > 60}">及格</c:when>
    <c:when test="${score < 60 and score >= 0}">不及格</c:when>
    <c:otherwise>无效成绩</c:otherwise>
</c:choose>

<hr>
<%--c:url路径--%>
<a href="JSTLNote.jsp">JSTLNote.jsp</a><br/>
<a href="/jsp/JSTLNote.jsp">JSTLNote.jsp</a><br/><%--jsp中不建议使用绝对路径--%>
<a href="<%=request.getContextPath()%>/JSTLNote.jsp">JSTLNote.jsp</a><br/>
<a href="<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%>/JSTLNote.jsp">JSTLNote.jsp</a><br/>
<a href="${pageContext.request.contextPath }/JSTLNote.jsp">JSTLNote.jsp</a><br/>
<a href="<c:url value='/JSTLNote.jsp'/>">JSTLNote.jsp</a><br/>
</body>
</html>
