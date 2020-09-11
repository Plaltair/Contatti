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
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="/">Trasporti</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	</nav>
	
	<div class="container" align="center">
		<form action="/modifica_check">
			<h3>Modifica automezzo</h3> <br>
			<div class="form-group">
    			<input type="text" class="form-control" placeholder="Inserisci targa" name="targa" id="targa" value="${automezzo.targa}" readonly="readonly">
			</div> <br>
			<div class="form-group">
    			<div class="input-group mb-3">
				  <select class="custom-select" id="destinazione" name="destinazione" id="destinazione" required="required">
					  <option value="" disabled selected>Destinazioni disponibili...</option>
					  <c:forEach items="${destinazioni}" var="destinazione">
					  	<c:if test="${empty destinazione.automezzo}">
					  		<option value="${destinazione.id}">Destinazione: ${destinazione.citta}. Distanza: ${destinazione.distanza}</option>
					  	</c:if>
					  </c:forEach>
				  </select>
				  <div class="input-group-append">
				    <label class="input-group-text" for="inputGroupSelect02">Opzioni</label>
				  </div>
				</div>
			</div> <br>
			<button type="submit" class="btn btn-primary">Modifica</button>
		</form>
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>