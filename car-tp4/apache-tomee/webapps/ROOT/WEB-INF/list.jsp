<%@ page pageEncoding="UTF-8" %>
<%@ page import="car.tp4.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Iterator"%>

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
		int pSize = (Integer) request.getAttribute("p-size");
		Set<Entry<Book, Integer>> commande = (Set<Entry<Book, Integer>>) request.getAttribute("p-list");
		%>
		<div class="row">
			<div class="col col-xs-6 pull-right">
				<div class="panel panel-primary">
					<div class="panel-heading">Votre panier d'achat</div>
					<div class="panel-body">
						<span style="background-color: red ! important;" class="text-danger badge"><% out.print(""+pSize); %></span> Items
					</div>
				</div>
				<ul class="list-group text-left">
		<% 
			if (commande != null){
				Iterator it = commande.iterator();
				while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        Book livre = (Book) pair.getKey();
			        int qte = (Integer) pair.getValue();
		 %>
					<li style="" class="list-group-item">
						<% out.print(livre); %>
						<form class="" style="display: inline-block;" action="/car/tp4/rmcart" method="get">
							<input name="id" value="<% out.print(livre.getId()); %>" class="sr-only" type="text">
							<button type="submit" class="btn btn-danger">
								Supprimer
							</button>
						</form>
						<span class="badge"> <% out.print(qte); %> </span>
					</li>
		 <%
		 		}
		 	}
		 %>
				</ul>
		<%
			if (pSize > 0){
		%> 
				<div class="row"><div class="col-xs-6 pull-right"><a href="/car/tp4/confirm" class="btn btn-success btn-block">Confirmer commande</a></div></div>
		<%
			}
		%>
			</div>
		</div>
		<div class="row text-center">
			<div class="col col-xs-12 col-md-6">
				<h2 class="row">Liste des livres
		<%
		
		List<Book> livres = (List<Book>) request.getAttribute("list");
		if ( livres != null ) {
			if (livres.size() == 0) out.print("</h2><b>Bibliothèque vide !</b>");
			else out.print(" <span class=\"badge blue\">("+livres.size()+" livres)</span> </h2>");
		%>
		
				<table class="table table-hover table-bordered">
				  <tr>
				  	<th>#</th>
				    <th>Titre</th>
				    <th>Auteur</th>		
				    <th>Année</th>
				    <th>Ajouter au panier</th>
				  </tr>
		<%
			for(Book b : livres){
		%>
				  <tr>
					<form action="/car/tp4/addcart" method="get">
					  	<td><% out.print(b.getId()); %> <input type="text" name="id" value="<% out.print(b.getId()); %>" class="sr-only"/></td>
					    <td><% out.print(b.getTitle()); %> <input type="text" name="author" value="<% out.print(b.getTitle()); %>" class="sr-only"/></td>
					    <td><% out.print(b.getAuthor()); %> <input type="text" name="title" value="<% out.print(b.getAuthor()); %>" class="sr-only"/></td>		
					    <td><% out.print(b.getYear()); %> <input type="text" name="year" value="<% out.print(b.getYear()); %>" class="sr-only"/></td>
					    <td>
					    	<button type="submit" class="btn btn-success">
							  Ajouter <i class="fa fa-plus-square-o"></i>
							</button>
					    </td>
					</form>	
				  </tr>
		<%
			}
		}
		else out.print("<b>Bibliothèque injoignable</b>");
		
		%>	
				</table>
			</div>
			
			<div class="col col-xs-12 col-md-6">
				<h2>Liste des Auteurs</h2>
				<ul class="list-group">
		<%
			List<Author> auteurs = (List<Author>) request.getAttribute("authors");
			if ( auteurs != null ) {
				for(Author a : auteurs){
		%>
				  <li class="list-group-item">
					<% out.print(a); %>
				  </li>
		<%
				}
			}
			else out.print("<b>Pas d'auteurs connus</b>");
		
		%>	
			</div>
		</div>
		<div class="row text-center">
			<a href="/car/tp4">Retour Accueil</a>
		</div>

	</body>
</html>
