<%@ page pageEncoding="UTF-8" %>
<%@ page import="car.tp4.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>CAR TP4 - Exo 2</title>
		<link rel="stylesheet" href="/css/font-awesome.min.css">
		
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css"/>
	</head>
	<body class="container text-center" style="margin-top:80px;">
		<%
		
		//String author = request.getParameter("author");
		Book livre = (Book) request.getAttribute("livre");
		if ( livre != null ) {
			//String title = request.getParameter("title");
		    String year = request.getParameter("year");
			//Book livre = new Book(new Author(author),title);
		    out.print("Auteur : "+livre.getAuthor().toString()+"<br/>");
		    out.print("Titre : "+livre.getTitle()+"<br/>");
		    out.print("Ann&eacute; : "+year+"<br/><p/>");
		} else out.print("<b>Pas de livre ajouté récemment.</b>");
		
		%>
		
		<h1>Ajout d'un livre</h1>
		<a href="/car/tp4/list">Voir la liste des livres et des auteurs</a>
		<form action="/car/tp4/add" method="GET">
			Auteur : <input type="text" name="author"><br/>
			Titre : <input type="text" name="title"><br/>
			Ann&eacute;e : <input type="text" name="year"><br/>
			<input type="submit">
		</form>
	</body>
</html>
