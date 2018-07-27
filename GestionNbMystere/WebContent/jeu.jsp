<%@page import="GestionNbMystere.Scores.GestionScores"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="JSP/bandeau.jsp"></jsp:include>
<body>

<div class="wrapper">
	<div class="titre">
		<h3>Donner un chiffre entre 0 et 100 </h3>
	</div>
<%
	if(session.getAttribute("nombre") != null){
		GestionScores gs = (GestionScores) session.getAttribute("nombre");
		out.print(gs.getMystere().toString());
	}
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
	<div id="scores">
		<div id="actuel">
			<h3>Score</h3>
			<% 
			if(session.getAttribute("nombre") != null) {
				if(session.getAttribute("win") != null){
					GestionScores tempGs = (GestionScores) session.getAttribute("nombre");
					if((boolean) session.getAttribute("win") == true){
						out.print("<p class='alert alert-success'>" + tempGs.getCoups().size() +  " </p>");
					}
					else{
						out.print("<p>" + tempGs.getCoups().size() + " </p>");
					}
				}
			 }
			else{
				out.print("0");
			}
				%> 
		</div>
		<div id="meilleur">
			<h3> Meilleur score</h3>
			<p><% 
				if(session.getAttribute("nombre") != null){
					GestionScores gs = (GestionScores) session.getAttribute("nombre");
					if(gs.getSolve().size() > 0){
						out.print(gs.getSolve().stream().mapToInt(x -> x).min().getAsInt());
					}
				}
			%></p>		
		</div>
		<div id="historique">
			<h3>Historique des coups</h3>
			<% if(session.getAttribute("nombre") != null){
				GestionScores gs = (GestionScores) session.getAttribute("nombre");
				if(gs.getCoups().size() > 0){
					for(int i : gs.getCoups()){
						out.print("<span>"+ i +" </span>");											
					}
				}
				else{}
			}
				
				%>
		</div>
	</div>
</div>
<jsp:include page="JSP/pied.jsp"></jsp:include>
