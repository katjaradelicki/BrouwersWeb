<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Brouwers</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/styles/default.css">
<style>
form, form input {
display:inline; 
}
form {
margin-right:5px;
}
</style>
</head>
<body>
<a href="<c:url value='/'/>">Menu</a>
<h1>Brouwer toevoegen</h1>
<c:url value="/brouwers/toevoegen" var="url"/>
<form:form method="post" action="${url}" commandName="brouwer">
<form:label path="naam">Naam:<form:errors cssClass="fout" path="naam"></form:errors></form:label><br/>
<form:input path="naam" /><br/>
<form:label path="adres.straat">Straat:<form:errors cssClass="fout" path="adres.straat"></form:errors></form:label><br/>
<form:input path="adres.straat" /><br/>
<form:label path="adres.huisNr">Huisnr:<form:errors cssClass="fout" path="adres.huisNr"></form:errors></form:label><br/>
<form:input path="adres.huisNr" /><br/>
<form:label path="adres.postcode">Postcode:<form:errors cssClass="fout" path="adres.postcode"></form:errors></form:label><br/>
<form:input path="adres.postcode" /><br/>
<form:label path="adres.gemeente">Gemeente:<form:errors cssClass="fout" path="adres.gemeente"></form:errors></form:label><br/>
<form:input path="adres.gemeente" /><br/>
<form:label path="omzet">Omzet:<form:errors cssClass="fout" path="omzet"></form:errors></form:label><br/>
<form:input path="omzet" /><br/>

<input type="submit" value="Toevoegen" id="toevoegKnop">

</form:form>
</body>
</html>