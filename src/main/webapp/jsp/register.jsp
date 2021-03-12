<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Enregistrement</title>
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<style>
			body {
				color: #fff;
				background: #63738a;
				font-family: 'Roboto', sans-serif;
			}
			
			.form-control {
				height: 40px;
				box-shadow: none;
				color: #969fa4;
			}
			
			.form-control:focus {
				border-color: #5cb85c;
			}
			
			.form-control, .btn {
				border-radius: 3px;
			}
			
			.signup-form {
				width: 450px;
				margin: 0 auto;
				padding: 30px 0;
				font-size: 15px;
			}
			
			.signup-form h2 {
				color: #636363;
				margin: 0 0 15px;
				position: relative;
				text-align: center;
			}
			
			.signup-form h2:before, .signup-form h2:after {
				content: "";
				height: 2px;
				width: 30%;
				background: #d4d4d4;
				position: absolute;
				top: 50%;
				z-index: 2;
			}
			
			.signup-form h2:before {
				left: 0;
			}
			
			.signup-form h2:after {
				right: 0;
			}
			
			.signup-form .hint-text {
				color: #999;
				margin-bottom: 30px;
				text-align: center;
			}
			
			.signup-form form {
				color: #999;
				border-radius: 3px;
				margin-bottom: 15px;
				background: #f2f3f7;
				box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
				padding: 30px;
			}
			
			.signup-form .form-group {
				margin-bottom: 20px;
			}
			
			.signup-form input[type="checkbox"] {
				margin-top: 3px;
			}
			
			.signup-form .btn {
				font-size: 16px;
				font-weight: bold;
				min-width: 140px;
				outline: none !important;
			}
			
			.signup-form .row div:first-child {
				padding-right: 10px;
			}
			
			.signup-form .row div:last-child {
				padding-left: 10px;
			}
			
			.signup-form a {
				color: #fff;
				text-decoration: underline;
			}
			
			.signup-form a:hover {
				text-decoration: none;
			}
			
			.signup-form form a {
				color: #5cb85c;
				text-decoration: none;
			}
			
			.signup-form form a:hover {
				text-decoration: underline;
			}
		</style>
	</head>
	<body>
		<div class="signup-form">
		    <form action="register" method="post">
				<h2>S'enregistrer</h2>
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
		            <button type="submit" class="btn btn-success btn-lg btn-block">S'enregistrer</button>
		        </div>
		    </form>
			<div class="text-center">Vous êtes déjà inscrit ?<a href="login">Se connecter</a></div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>