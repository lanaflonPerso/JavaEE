<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><spring:message code="titre.baptiste"/></title>
	</head>
	<body>
		<h1>${personne}</h1>
		<p><% out.print(request.getContextPath()); %></p>
		<spring:message code="description.baptiste" arguments="${personne}"/>
		
		<form method="post" action="<% out.print(request.getContextPath()); %>/control">
			<input type="text" name="personne">
			<input type="text" name="metier">
			<input type="submit" name="welcome">
		</form>
	</body>
</html>