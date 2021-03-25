<nav class="navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="#">
    	<img src="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" width="40" height="25" alt="">
    	Les Amis de l'Escalade
   	</a>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown dropleft">
			<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" >
				<span class="bi bi-person-circle"></span> Utilisateur: ${utilisateur.pseudo}
			</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Espace personnel</a> 
				<a class="dropdown-item" href="#">Listes des topos</a> 
				<a class="dropdown-item" href="#">Gestion des réservations</a>
				<a class="dropdown-item bi bi-box-arrow-left" href="/lesamisdelescalade/logout"> Se déconnecter</a>
			</div>
        </li>
    </ul>
</nav>