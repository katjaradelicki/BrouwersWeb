<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang="nl">
<head>
<title> <fmt:message key="Geen toegang" /></title>
<link rel="stylesheet"
href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<a href='<c:url value="/"/>'>Menu</a>
U hebt geen toegang
</body>
</html>