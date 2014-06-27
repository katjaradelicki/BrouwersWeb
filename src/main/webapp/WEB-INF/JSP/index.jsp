<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
<!doctype html>
<html lang="nl">
<head>
<title> <fmt:message key="menu" /></title>
<link rel="stylesheet"
href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<security:authorize access="isAuthenticated()">
<fmt:message key='dag' /> <security:authentication property="name"/>
</security:authorize>
<nav>
<ul class="zonderbolletjes">
<security:authorize access="isAnonymous()">
<li><a href="<c:url value='/login'/>"> <fmt:message key="aanmelden"/> </a></li>
</security:authorize>
<security:authorize access="isAuthenticated()">
<li><a href="<c:url value='/j_spring_security_logout'/>"> <fmt:message key="afmelden"/> </a></li>
</security:authorize>
</ul>
<ul class="zonderbolletjes">
<li><a href="<c:url value='/brouwers'/>"> <fmt:message key="alleBrouwers"/> </a></li>
<li><a href="<c:url value='/brouwers/opnaam'/>"> <fmt:message key="brouwersOpNaam"/></a></li>
<li><a href="<c:url value='/brouwers/toevoegen'/>"><fmt:message key="brouwerToevoegen"/> </a></li>
<li><a href="<c:url value='/brouwers/opalfabet'/>"><fmt:message key="brouwersOpAlfabet" /> </a></li>
</ul>
</nav>
<fmt:message key="${groet}"></fmt:message>
</body>
</html>