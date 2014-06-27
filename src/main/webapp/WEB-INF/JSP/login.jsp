<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'>
<title><fmt:message key="aanmelden"/></title>
</head>
<body>
<h1><fmt:message key="aanmelden"/></h1>
<form method='post' action='<c:url value="/j_spring_security_check"/>'
id='aanmeldform'>
<label> <fmt:message key="gebruikersnaam"/>:   
<input name='j_username' autofocus></label> 
<label><fmt:message key="paswoord"/>:
<input type='password' name='j_password'></label> 
<input type='submit' value='<fmt:message key="aanmelden"/>' id='aanmeldknop'>
<div class='rij'><label><input type="checkbox" name="_spring_security_remember_me"/><fmt:message key="onthoudMe"/></label></div>
<c:if test="${param.error}">
<div class='fout'><fmt:message key="verkeerdeGebruikersnaamOfPaswoord"></fmt:message></div>
</c:if>
</form>
</body>
<script>
document.getElementById('aanmeldform').onsubmit= function() {
document.getElementById('aanmeldknop').disabled=true;
};
</script>
</html>