<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Enregistrement</title>
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		    	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		    	crossorigin="anonymous">
	    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" sizes="192x192" />
	</head>
	<body>
 		<div class="container col-md-6 col-md-offset-3" style="overflow: auto">
 		<img src="${pageContext.request.contextPath}/img/lesamisdelescalade_lg.png" class="rounded mx-auto d-block" alt="Les Amis de l'Escalade">
			<div class="border border-light p-2">
			    <form action="register" method="post">
			        <div class="form-group">
						<div class="row">
							<div class="col"><input type="text" class="form-control" name="prenom" placeholder="Prénom" required="required"></div>
							<div class="col"><input type="text" class="form-control" name="nom" placeholder="Nom" required="required"></div>
						</div>        	
			        </div>
			        <div class="form-group">
			        	<input type="text" class="form-control" name="pseudo" placeholder="Pseudo" required="required">
			        </div>
					<div class="form-group">
			            <input type="password" class="form-control" name="motDePasse" placeholder="Mot de passe" required="required">
			        </div>
			        <div class="form-group">
			        	<input type="text" class="form-control" name="numTel" placeholder="Téléphone" required="required">
			        </div>
			        <div class="form-group">
			        	<input type="email" class="form-control" name="email" placeholder="Email" required="required">
			        </div>
			        <div class="form-group">
			        	<input type="text" class="form-control" name="adresse" placeholder="Adresse" required="required">
			        </div>
			        <div class="form-group">
			        	<input type="text" class="form-control" name="codePostal" placeholder="Code postal" required="required">
			        </div>
                	<div class="form-group">
	               		<div class="custom-control custom-checkbox">
							<input type="checkbox" id="membreAssoYN" name="membreAssoYN" value="membreAssoYN" class="custom-control-input" /> 
							<label class="custom-control-label" for="membreAssoYN">Membre de l'association</label>
						</div>	
               		</div>
					<div class="form-group">
			            <button type="submit" class="btn btn-primary btn-lg btn-block">S'enregistrer</button>
			        </div>
			    </form>
				<div class="text-center">Vous êtes déjà inscrit ?</div>
				<div class="text-center"><a href="login" class="btn btn-primary">Se connecter</a></div>
				<div class="${requestScope.registerError ne null ? 'alert alert-danger' : 'alert alert-danger collapse'}">
					<strong>Attention.</strong> ${requestScope.registerError}
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>