<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel='stylesheet' href="${pageContext.servletContext.contextPath}/styles/default.css">
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Brouwers op naam</h1>
<c:url value="/brouwers/opnaam" var="url"/>
<form:form commandName="brouwersOpNaamForm" method="get" action="${url}">
<form:label path="beginNaam" >Begin van de naam: </form:label>
<br/>
<form:input type="text" path="beginNaam" autofocus="autofocus"/> <form:errors path="beginNaam" cssClass="fout" ></form:errors>
<br/>
<input type="submit" value="Zoeken" >
</form:form>
<c:if test="${not empty gevondenBrouwers}">
<ul>
<c:forEach items="${gevondenBrouwers}" var="brouwer">
<li>${brouwer.naam}</li>
</c:forEach>
</ul>
</c:if>
</body>
</html>