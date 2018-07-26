<%@page import="GestionNbMystere.Scores.GenerationNombreMystere"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="JSP/bandeau.jsp"></jsp:include>
<body>

<div class="wrapper">
	<div class="titre">
		<h3>Donner un chiffre entre 0 et 100 </h3>
	</div>
<%
	out.print(session.getAttribute("nombre"));
	%>
	<div class="saisie">
		<form method="post" action="./Nombre" class="form-group">
			<label class="" for="proposition">Saisie du chiffre</label>
			<input class="form-control" type ="number" name="proposition" id="proposition" required/>
			<input class="btn" type="submit" name="proposer" value="Jouer"/>
		</form>
	</div>
	<div class="results">
		<form method="post" action="./nouveauNombre">
			<input class="btn" type="submit" name="rejouer" value="Nouvelle Partie">
		</form>
	</div>
	<div class="affichage">
		<div id="listeCoups">
			<ul><% 
			if(session.getAttribute("log") != null){
				String[] log = session.getAttribute("log").toString().split("  ");
				for(String s : log){
					out.print(s);				
				}				
			}
		%>
			</ul>
		</div>
		<div>
			<h3>Score</h3>
			<p> <% out.print(session.getAttribute("count")); %> </p>
			<h3> Meilleur score</h3>
			<p><% 
			if(session.getAttribute("highscore") != null){
				out.print(session.getAttribute("highscore")); 
			}
			else{
				out.print("Pas encore de meilleur score");
			}
			%></p>
		</div>
	</div>
</div>
<jsp:include page="JSP/pied.jsp"></jsp:include>
