<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="Lilian">
		
		<title>Les Amis de l'Escalade</title>
		
		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<link rel="shortcut icon" type="image/png" href="/img/lesamisdelescalade_lg.png"/>
	</head>
	<body>
		<!-- Page Content -->
		<div class="container">
			<jsp:include page='include/navbar.jsp'/>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item active">
						<a href="/lesamisdelescalade/home">Accueil</a>
					</li>
					<li class="breadcrumb-item active" aria-current="page">
						<a href="${request.requestURL}">Gestion des réservations</a>
					</li>
				</ol>
			</nav>
	
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-hover table-bordered">
						<caption>Demandes de réservation sur vos topos</caption>
						<thead>
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Description</th>
								<th scope="col">Date de parution</th>
								<th scope="col">Site concerné</th>
								<th scope="col">Statut de la demande</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="topo" items="${toposAccept}" >
								<tr>
									<th scope="row">${topo.nom}</th>
									<td>${topo.description}</td>
									<td><fmt:formatDate value="${topo.dateParution}" pattern="dd/MM/yyyy" /></td>
									<td>${topo.site.libelle}</td>
									<td>${topo.statutTopo.libelle}</td>
									<td>
										<a href="reservations?accept=${topo.id}" class="btn btn-success">
											Accepter
										</a>
										<a href="reservations?refuse=${topo.id}" class="btn btn-danger">
											Refuser
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
				<!-- /.col-lg-12 -->
				<div class="col-lg-12">
					<table class="table table-hover table-bordered">
						<caption>Demandes de réservation acceptés</caption>
						<thead>
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Description</th>
								<th scope="col">Date de parution</th>
								<th scope="col">Site concerné</th>
								<th scope="col">Statut de la demande</th>
								<th scope="col">Emprunteur</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="topo" items="${toposReserves}" >
								<tr>
									<th scope="row">${topo.nom}</th>
									<td>${topo.description}</td>
									<td><fmt:formatDate value="${topo.dateParution}" pattern="dd/MM/yyyy" /></td>
									<td>${topo.site.libelle}</td>
									<td>${topo.statutTopo.libelle}</td>
									<td>${topo.emprunteur.prenom} ${topo.emprunteur.nom}</td>
									<td>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#topo${topo.id}">
										  	Afficher les coordonnées
										</button>
										<a href="reservations?refuse=${topo.id}" class="btn btn-danger">
											Mettre fin à ce prêt
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<hr class="solid">
			</div>
			<!-- /.row -->
			
			<!-- modals -->
			<c:forEach var="topo" items="${toposReserves}" >
				<div class="modal fade" id="topo${topo.id}" role="dialog" aria-labelledby="topo${topo.id}Label" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="topo${topo.id}Label">Coordonnées du propriétaire</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				      	<p>Nom: ${topo.emprunteur.nom}</p>
				      	<p>Prénom: ${topo.emprunteur.prenom}</p>
				      	<p>Téléphone: ${topo.emprunteur.numeroTel}</p>
				      	<p>Adresse: ${topo.emprunteur.adresse} ${topo.emprunteur.codePostal}</p>
				      	<p>Email: ${topo.emprunteur.email}</p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
				      </div>
				    </div>
				  </div>
				</div>
			</c:forEach>
			<!-- /.modals -->
		</div>
		<!-- /.container -->
	
		<!-- Footer -->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your
					Website 2020</p>
			</div>
			<!-- /.container -->
		</footer>
	
		<!-- Bootstrap core JavaScript -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>
