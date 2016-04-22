<%@ page pageEncoding="UTF-8" %>
<%@ page import="car.tp4.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>CAR TP4 - Exo 2</title>
	</head>
	<body>
		<h1>Liste des livres
		<%
		
		LibraryItf livres = (LibraryItf) application.getAttribute("BIBLI");
		if ( livres != null ) {
			if (livres.getAllBooks().size() == 0) out.print("</h1><b>Bibliothèque vide !</b>");
			else out.print(" ("+livres.getAllBooks().size()+") </h1>");
			out.print("<ul>");
			for(Book b : livres.getAllBooks()){
				out.print("<li>"+b+"</li>");
			}
		    out.print("</ul>");
		}
		else out.print("<b>Bibliothèque indisponible</b>");
		
		%>

		<a href="/index.jsp">Retour Accueil</a>
	</body>
</html>
