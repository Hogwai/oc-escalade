<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/home">
    	<img src="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" width="40" height="25" alt="Les Amis de l'Escalade">
    	Les Amis de l'Escalade
  	</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
        aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
	    	<li class="nav-item mb-2 mr-2">
	           	<a class="btn btn-info bi bi-search" href="${pageContext.request.contextPath}/recherchesite"> Recherche</a>
	    	</li>
         	<li class="nav-item dropdown dropleft">
				<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" >
					<span class="bi bi-person-circle"></span> Utilisateur: ${utilisateur.pseudo}
				</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/profil">Espace personnel</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath}/listetopos">Listes des topos</a> 
					<a class="dropdown-item" href="${pageContext.request.contextPath}/reservations">Gestion des réservations</a>
					<a class="dropdown-item bi bi-box-arrow-left" href="${pageContext.request.contextPath}/logout"> Se déconnecter</a>
				</div>
	        </li>
        </ul>
    </div>
</nav>