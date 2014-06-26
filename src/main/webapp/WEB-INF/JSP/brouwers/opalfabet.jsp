<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Brouwers op alfabet ${param.gekozenLetter}</h1> 
<ul class="zonderbolletjes">
<c:forEach items="${alfabet}" var="letter">
<c:url var="urlOpLetter" value="/brouwers/opalfabet">
<c:param name="gekozenLetter" value="${letter}"></c:param>
</c:url>
<li> <a href="${urlOpLetter}"> ${letter} </a></li></c:forEach>

</ul>

<c:if test="${!empty gevondenBrouwers}">
<ul>
<c:forEach items="${gevondenBrouwers}" var="brouwer">
<li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
</c:forEach>
</ul>
</c:if>

</body>
</html>