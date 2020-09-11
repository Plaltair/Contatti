<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="aggiungi_destinazione_check">
			<h3>Aggiungi destinazione</h3> <br>
			<div class="form-group">
    			<input type="text" class="form-control" id="targa" placeholder="Inserisci città" name="citta" id="citta" required="required">
			</div> <br>
			<div class="form-group">
    			<input type="text" class="form-control" id="targa" placeholder="Inserisci distanza" name="distanza" id="distanza" required="required">
			</div> <br>
			<button type="submit" class="btn btn-primary">Aggiungi destinazione</button>
		</form>
	</div>
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>