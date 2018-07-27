<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<form method="post" action="./Identification" class="form-group">
	    <label>Login :</label>
	    <input class="form-control" type="text" required value="" name="slogin"><br/>
	    <label>Mot de Passe :</label>
	    <input class="form-control" type="password" required value="" name="smdp"><br/>    
	    <input class="btn" type="submit" value="Connexion">
	</form>

<jsp:include page="JSP/pied.jsp"></jsp:include>
