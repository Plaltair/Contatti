<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Società di trasporti</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="/">Trasporti</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/">Visualizza trasporti <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/automezzi">Visualizza automezzi</a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" href="/destinazioni">Visualizza destinazioni</a>
	      </li>
	    </ul>
	  </div>
	  <form class="form-inline">
	    <input class="form-control mr-sm-2" type="search" placeholder="Filtra" aria-label="Search" id="search">
	  </form>
	</nav>
	
	<table class="table">
		<thead align="center">
			<tr>
		    	<th scope="col">Città</th>
		    	<th scope="col">Distanza</th>
		    	<th scope="col">Elimina</th>
		   	</tr>
		</thead>
		<tbody align="center" id="table_destinazioni">
			<c:forEach items="${destinazioni}" var="destinazione">
				<tr>
			      	<td>${destinazione.citta}</td>
			      	<td>${destinazione.distanza}</td>
			      	<td>
			      		<form action="/elimina_destinazione">
			      			<input type="hidden" value="${destinazione.id}" name="id">
			      			<input type="hidden" value="${destinazione.citta}" name="citta">
			      			<input type="hidden" value="${destinazione.distanza}" name="distanza">
			      			<button type="submit" class="btn btn-danger">Elimina</button> 
			      		</form>
			      	</td>
		   		</tr>
			</c:forEach>
			<tr>
				<td><a href="/aggiungi_destinazione"> <button type="button" class="btn btn-primary">Aggiungi destinazione</button> </a></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<script>
		$(document).ready(function(){
		  $("#search").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#table_destinazioni tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
	</script>
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>