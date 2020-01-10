<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/static/css/title.css" rel="stylesheet">
    <title>Hello ${name}!</title>
</head>
<body>
<h2 class="hello-title">Hello ${name}!</h2>

<p>
    Hello <c:if test="${name == null}">NoBody</c:if>!
</p>

<p>
    Hello
    <c:choose>
        <c:when test="${name ==null}">
            NoBody
        </c:when>
        <c:otherwise>
            ${name}
        </c:otherwise>
    </c:choose>
    !
</p>

<%--通过Java代码定义--%>
<%
    String[] str={"1","2","3","4","5","6","7"};
    request.setAttribute("str",str);
%>
<c:forEach items="${str}" var="s">
    <!-- 输出标签，相当于System.out.println(s); -->
    <c:out value="${s}"/><br>
</c:forEach>

</body>
</html>