<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<%@ page import="java.text.*,java.util.*" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Connexion</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" sizes="192x192" />
    </head>
    <body>
	    <div class="container col-md-6 col-md-offset-3" style="overflow: auto">
	    	<img src="${pageContext.request.contextPath}/img/lesamisdelescalade_lg.png" class="rounded mx-auto d-block" alt="Les Amis de l'Escalade">
	        <form action="login" method="POST" class="mb-3">
	            <div class="form-group">
	                <label for="username">Pseudo:</label>
	                <input type="text" class="form-control" id="pseudo" placeholder="Pseudo" name="pseudo" required/>
	            </div>
	            <div class="form-group">
	                <label for="password">Mot de passe:</label>
	                <input type="password" class="form-control" id="motDePasse" placeholder="Mot de passe" name="motDePasse" required/>
	            </div>
	            <button type="submit" class="btn btn-primary btn-lg btn-block">Se connecter</button>
	        </form>
	        <div class="text-center">Vous n'êtes pas inscrit ?</div>
	        <div class="text-center"><a href="register" class="btn btn-primary">S'inscrire</a></div>
	       	<div class="${requestScope.loginError ne null ? 'alert alert-danger' : 'alert alert-danger collapse'}">
				<strong>Attention.</strong> ${requestScope.loginError}
			</div>
	    </div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>