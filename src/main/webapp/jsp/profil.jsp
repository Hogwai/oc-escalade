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
						<a href="${request.requestURL}">Profil</a>
					</li>
				</ol>
			</nav>
			
			<div class="row">
				<div class="col-lg-12">
					<form class="my-2 px-3 pt-3 border rounded" action="${pageContext.request.contextPath}/profil?add" method="POST">
					    <div class="form-row">
					        <div class="col-auto form-group">
					            <button class="btn btn-warning d-block collapsed" data-toggle="collapse" data-target="#collapseRegisterTopo" aria-expanded="false" aria-controls="collapseRegisterTopo">
					            	Enregistrer un nouveau topo
				            	</button>
					        </div>
					    </div>
					    <div class="collapse" id="collapseRegisterTopo">
					   		<div class="form-row">
   						        <div class="col-6 form-group">
						            <label for="nom">Nom du topo</label>
						            <input class="form-control" id="nom" type="text" placeholder="Nom du topo" name="nom" required>
						        </div>
						        
						        <div class="col-6 form-group">
					                <label for="siteId">Site:</label>
					                <select class="form-control" id="siteId" type="text" name="siteId">
					                	<c:forEach var="site" items="${sites}" >
						                    <option value="${site.id}">${site.libelle}</option>
					                    </c:forEach>
					                </select>
								</div>
				         	</div>
				         	
				         	<div class="form-row">
		                        <label for="description">Description</label> 
		                        <textarea name="description" id="description" class="form-control" required></textarea>
				         	</div>
				         	 <button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Enregistrer</button>
					    </div>
					</form>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-hover">
						<caption>Topos</caption>
						<thead>
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Description</th>
								<th scope="col">Date de parution</th>
								<th scope="col">Statut</th>
								<th scope="col">Emprunteur</th>
								<th scope="col">Site concerné</th>
								<th scope="col">Disponible ?</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="topo" items="${topos}" >
								<tr>
									<th scope="row">${topo.nom}</th>
									<td>${topo.description}</td>
									<td><fmt:formatDate value="${topo.dateParution}" pattern="dd/MM/yyyy" /></td>
									<td>${topo.statutTopo.libelle}</td>
									<td>${topo.emprunteur eq null ? "Non" : topo.emprunteur.nom.concat(' ').concat(topo.emprunteur.prenom)}</td>
									<td>${topo.site.libelle}</td>
									<td>
										<a href="profil?modify=${topo.id}&statut=${topo.statutTopo.id}" class="btn ${topo.statutTopo.id eq 1 ? 'btn-danger' : 'btn-success' }">
											Rendre <c:out value="${topo.statutTopo.id eq 1 ? 'indisponible' : 'disponible' }" />
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
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
