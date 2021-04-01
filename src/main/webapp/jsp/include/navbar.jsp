<nav class="navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
    	<img src="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" width="40" height="25" alt="Les Amis de l'Escalade">
    	Les Amis de l'Escalade
   	</a>
    <ul class="navbar-nav ml-auto">
    	<li class="nav-item mr-3">
           	<a class="btn btn-info bi bi-search" href="${pageContext.request.contextPath}/recherchesite"> Recherche</a>
    	</li>
        <li class="nav-item dropdown dropleft">
			<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" >
				<span class="bi bi-person-circle"></span> Utilisateur: ${utilisateur.pseudo}
			</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/profil">Espace personnel</a> 
				<a class="dropdown-item" href="#">Listes des topos</a> 
				<a class="dropdown-item" href="#">Gestion des réservations</a>
				<a class="dropdown-item bi bi-box-arrow-left" href="${pageContext.request.contextPath}/logout"> Se déconnecter</a>
			</div>
        </li>
    </ul>
</nav>