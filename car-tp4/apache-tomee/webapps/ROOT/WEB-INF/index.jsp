<%@ page pageEncoding="UTF-8" %>
<%@ page import="car.tp4.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>CAR TP4 - Exo 2</title>
	</head>
	<body>
		<h1>Ajout d'un livre</h1>
		<%
		
		Book livre = (Book) request.getAttribute("livre");
		if ( livre != null ) {
		    out.print("Livre ajouté : "+livre.toString());
		}
		else out.print("toto");
		
		%>
		<h1>Liste des livres</h1>
		<%
		
		Library livres = (Library) request.getAttribute("BIBLI");
		if ( livres != null ) {
			out.print("<ul>");
			for(Book b : livres.getAllBooks()){
				out.print("<li>"+b+"</li>");
			}
		    out.print("</ul>");
		}
		else out.print("Pas de livres");
		
		%>
		
		<form action="/car/tp4/add" method="POST">
			Auteur : <input type="text" name="author"><br/>
			Titre : <input type="text" name="title"><br/>
			<input type="submit">
		</form>
	</body>
</html>
