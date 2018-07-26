<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
</head>
<body>
	<form method="post" action="./Identification">
	    <label>Login :</label>
	    <input type="text" required value="" name="slogin"><br/>
	    <label>Mot de Passe :</label>
	    <input type="password" required value="" name="smdp"><br/>    
	    <input type="submit" value="Connexion">
	</form>

<jsp:include page="JSP/pied.jsp"></jsp:include>
