<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<%@ page import="java.text.*,java.util.*" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Connexion</title>
        <link rel="stylesheet" href="../resources/assets/css/login.css">
    </head>
    <body>
    <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
        <h1>Login Form</h1>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="username">Pseudo:</label>
                <input type="text" class="form-control" id="username" placeholder="Pseudo" name="username" required/>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" class="form-control" id="password" placeholder="Mot de passe" name="password" required/>
            </div>
            <button type="submit" class="btn btn-primary">Se connecter</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.js"></script>
    </body>
</html>