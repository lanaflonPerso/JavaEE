<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Jeu du nombre mystère</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="./css/style.css">
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
	</head>

	<% 
	    if(session.getAttribute("login") != null)
	    {
	        boolean bok = (boolean) session.getAttribute("login");
	        if(bok != true) {%>
	            <jsp:forward page="../login.jsp"></jsp:forward>
	        <%}
	    }
	    else 
	    {
	    %>
	    <jsp:forward page="../login.jsp"></jsp:forward>
	    <%
	    }%>