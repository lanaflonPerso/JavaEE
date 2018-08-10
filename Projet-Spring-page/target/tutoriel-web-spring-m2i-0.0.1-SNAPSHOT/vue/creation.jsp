<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><spring:message code="titre.creation.elementcourses"/></title>
		<spring:url value="/resources/style.css" var="stylecss" />
		<link href="${stylecss}" rel="stylesheet" />
	</head>
	<body>
		<form:form method="post" modelAttribute="creation" action="creerCreationListeCourses">
			<div id="crea-wrapper">
			<div class="creation">
			<spring:message code="creation.elementcourses.libelle.libelle" />
			<form:input path="libelle"/>
			<b><i><form:errors path="libelle" cssclass="error"/></i></b><br>
			</div>
			<div class="creation">
			<spring:message code="creation.elementcourses.libelle.quantite"/>
			<form:input path="quantite"/>
			<b><i><form:errors path="quantite" cssclass="error"/></i></b><br>
			</div>
			</div>
		<table>
			<thead>
				<tr>
					<th><spring:message code="colonne.identifiant"/></th>
					<th><spring:message code="colonne.libelle"/></th>
					<th><spring:message code="colonne.quantite"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listeCourses}" var="course">
					<tr>
						<td><c:out value="${course.id}"/></td>
						<td><c:out value="${course.libelle}"/></td>
						<td><c:out value="${course.quantite}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			<input type="submit"/>
		</form:form>
	</body>
</html>