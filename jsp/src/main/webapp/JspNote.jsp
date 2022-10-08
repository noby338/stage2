<%@ page import="java.util.Date" %><%-- <%@ %>表示指令，引入java的包 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
         language="java" errorPage="ExceptionNote.jsp" %><%--该jsp的页面编码解码格式为utf-8，支持的脚本语言为java--%>
<%--errorPage="ExceptionNote.jsp"表示异常后跳转的页面--%>
<html>
<head>
    <title>JspNote</title>
</head>
<body>

<%--动作,在jsp中引入其他页面，路径为服务器路径，同步方式--%>
<%--<jsp:include page="/HeaderAndFooterServlet?method=getHeader"/>--%>
<%--动作,在jsp中引入其他页面，路径为服务器路径，异步方式--%>
<jsp:include page="/footer.jsp"/>
<%--BaseServlet的使用--%>
<jsp:include page="/HeaderAndFooterServlet?method=getFooter"/>
<br>

<%--jsp本质上为一个servlet类，其java源代码位于target\tomcat\work\Tomcat\localhost\jsp\org\apache\jsp\JspNote_jsp.java--%>

<%--java脚本，里面存放java代码（java方法中的代码书写方式）--%>
<%
    //java的对象需要使用page指令的import属性导包
    Date date = new Date();
    //response为jsp的内置对象
    response.getWriter().write(String.valueOf(date));
    System.out.println("java对象" + date);

    //region jsp九大内置对象(JSP中特有的域：Page、PageContext)
     //page 就是this
    out.write("page==this:" + (page == this) + "<br/>");
    //request
    request.setAttribute("requestAttr", "request内置对象");
    //response
    response.getWriter().write("response内置对象<br/>");
    //session
    session.setAttribute("sessionAttr", "session内置对象");
    //application ServletContext
    application.setAttribute("applicationAttr", "application内置对象");
    //out JspWriter	字符流
    out.write("out内置对象<br/>");
    //config ServletConfig
    out.write(config.getServletName() + "<br/>");
    //exception
//        if(true) {
//            throw new RuntimeException("出现异常");
//        }
    //pageContext 其他的八个jsp内置对象都可以通过pageContext对象操作(只演示了5个)
    // page,request,session,ServletContext 为jsp的域属性
    // request,session,ServletContext 为servlet的域属性
    pageContext.setAttribute("pageContextAttr", "pageContext内置对象");
    pageContext.setAttribute("pageContextAttr", "pageContext内置对象 PAGE_SCOPE", PageContext.PAGE_SCOPE);
    pageContext.setAttribute("pageContextAttr", "pageContext内置对象 REQUEST_SCOPE", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("pageContextAttr", "pageContext内置对象 SESSION_SCOPE", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("pageContextAttr", "pageContext内置对象 APPLICATION_SCOPE", PageContext.APPLICATION_SCOPE);

    //page和request域可通过该方式调用，page>request的顺序查找
    out.write(pageContext.getAttribute("pageContextAttr").toString() + "<br/>");

    out.write(pageContext.getAttribute("pageContextAttr", PageContext.REQUEST_SCOPE).toString() + "<br/>");
    out.write(pageContext.getAttribute("pageContextAttr", PageContext.SESSION_SCOPE).toString() + "<br/>");
    out.write(pageContext.getAttribute("pageContextAttr", PageContext.APPLICATION_SCOPE).toString() + "<br/>");

    //全域查找，通过 page>pageContext>request>session>application 的顺序查找
    out.write(pageContext.findAttribute("pageContextAttr").toString());

%>
<%--声明，相当于该JspNote_jsp类的成员变量与成员方法（java类中的代码书写方式）--%>
<%!
    private static int count = 1;

    public static int getCount() {
        return count++;
    }
%>
<%--表达式，主要用于页面的输出操作--%>
<%=
"<h1>第 " + getCount() + " 次访问页面</h2>"
%>


<%--静态资源和java脚本嵌套使用--%>
<table>
    <%
        for (int i = 1; i <= 5; i++) {
    %>
    <tr>
        <td>
            <%="times" + i %>
        </td>
        <td>
            <%=i %>
        </td>
    </tr>
    <%} %>
</table>


</body>