<%--EL表达式主要用于简化JSP中的各种输出操作--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--taglib 为引入第三方标签库的指令，prefix为该标签指定别名（在调用时使用），uri为该标签的使用具体规则，使用前必须同时引入jstl--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--/jstl/core为jstl核心--%>
<%--/jstl/function为el函数库--%>

<html>
<head>
    <title>ELNote</title>
</head>
<body>
<%--模拟来自servlet的域对象--%>
<%
    request.setAttribute("info", "requestInformation");
    session.setAttribute("info", "sessionInformation");
    application.setAttribute("info", "applicationInformation");
%>
<%--EL的11个内置对象--%>
${info}<br><%--全域查找：会按照四大域从小到大查找该属性 注意${"info"}表示的是输出字符串"info"--%>
\${info}表示转译<br>
${requestScope.info}<br><%--${}即为EL的输出方式，等用于jsp中的<%= %>标签}--%>
${sessionScope.info}<br>
${applicationScope.info}<br>
<hr>
<%--EL运算符--%>
${not empty info}

    /或div
    %或mod
    ==或eq
    !=或ne
    <或lt
    >或gt
    <=或le
    >=或ge
    &&或and
    !或not
    ||或or
    empty

    <hr>
    <%--EL一共11个内置对象。这11个内置对象中有10个是Map类型的，最后一个是pageContext对象--%>
    pageScope 取page域中的值
    requestScope 取request域中的值
    sessionScope 取session域中的值
    applicationScope 取servletContext域中的值
    ${xxxScope.key} 查找指定域
    ${key} 全域 查找
    param 获取请求参数的值
    paramValues 一个请求参数key有多个值
    header 获取请求头的值
    headerValues 获取请求头的值，一个头名对应多个头值
    initParam 获取SerlvetContext初始化参数
    cookie 获取Cookie的值
    pageContext 获取其它内置对象


    <a href="ELNote.jsp">ELNote.jsp</a><br/>
    <%--jsp中不建议直接使用绝对路径--%>
    <a href="/jsp/ELNote.jsp">ELNote.jsp</a><br/>
    <!-- 绝对路径的灵活写法 -->
    <a href="<%=request.getContextPath() %>/ELNote.jsp">ELNote.jsp</a><br/>
    <a href="<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%>/ELNote.jsp">ELNote.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/ELNote.jsp">ELNote.jsp</a>
    <hr>

    <%--EL函数库（使用前导入jstl的jar包和jsp标签库）--%>
    ${fn:toUpperCase("java")}<%--表示使用fn标签中的toUpperCase()方法--%>
        String toUpperCase(String input)：
        String toLowerCase(String input)：
        int indexOf(String input, String substring)：
        boolean contains(String input, String substring)：
        boolean containsIgnoreCase(String input, String substring)：
        boolean startsWith(String input, String substring)：
        boolean endsWith(String input, String substring)：
        String substring(String input, int beginIndex, int endIndex)：
        String substringAfter(String input, String substring)：
        substringBefore(String input, String substring)：
        String escapeXml(String input)			对标签转义，显示原样字符，不显示标签效果
        String trim(String input)：
        String replace(String input, String substringBefore, String substringAfter)：
        String[] split(String input, String delimiters)：
        int length(Object obj)：
        String join(String array[], String separator)： 拼接
    <hr>
</body>
</html>
