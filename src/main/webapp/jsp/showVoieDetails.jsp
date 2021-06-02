<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/lesamisdelescalade_crop.png" sizes="192x192" />
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
					<li class="breadcrumb-item active">
						<a href="/lesamisdelescalade/site?siteId=${currentSite.id}">Site n°${currentSite.id}: ${currentSite.libelle}</a>
					</li>
					<li class="breadcrumb-item active">
						<a href="/lesamisdelescalade/secteur?secteurId=${currentSecteur.id}">Secteur n°${currentSecteur.id}: ${currentSecteur.libelle}</a>
					</li>
					<li class="breadcrumb-item active" aria-current="page">
						<a href="${request.requestURL}">Voie n°${currentVoie.id}</a>
					</li>
				</ol>
			</nav>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="card mb-3">
	       				<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addLongueur">
						  	Ajouter une longueur
						</button>
					</div>
					<!-- /.card mb-3 -->
					
					<div class="row">
						<c:forEach var="longueur" items="${currentVoie.longueurs}" >
						    <div class="col-lg-3 col-md-6 mb-4">
								<div class="card h-100">
									<div class="card-body">
										<h4 class="card-title">
											Longueur: <c:out value="${longueur.id}" />
										</h4>
										<p class="card-text">
											Cotation: <c:out value="${longueur.cotation.libelle}" />
											<div class="custom-control custom-checkbox">
												<input type="checkbox" id="relai" class="custom-control-input" ${longueur.relaiYN eq 1 ? "checked='checked'"  : ""} disabled /> 
												<label class="custom-control-label" for="relai">Relai</label>
											</div>
										</p>
									</div>
									<div class="card-footer">
									</div>
									<!-- /.card-footer -->
								</div>
								<!-- /.card h-100 -->
							</div>
							<!-- /.col-lg-4 col-md-6 mb-4 -->
						</c:forEach>
						<!-- /.forEach -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			
			<!-- modal -->
			<div class="modal fade" id="addLongueur" role="dialog" aria-labelledby="addLongueurLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="addLongueurLabel">Ajouter une longueur</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form action="${pageContext.request.contextPath}/voie?addLongueur" method="POST">
								<div class="form-row">
									<div class="col-12 form-group">
						            	<div class="custom-control custom-checkbox">
							                <input type="checkbox" class="custom-control-input" id="relaiYN" name="relaiYN" />
							                <label class="custom-control-label" for="relaiYN">Longueur avec relai</label>
				                		</div>
			                		</div>
										
					               	<div class="col-12 form-group">
					               		<label for="cotation">Cotation</label>
						                <select class="custom-select form-control" id="cotation" type="text" name="cotation">
						                	<c:forEach var="cotation" items="${cotations}" >
							                    <option value="${cotation.id}">${cotation.libelle}</option>
						                    </c:forEach>
						                </select>
						                <input type="hidden" id="voieId" name="voieId" value="${currentVoie.id}">
					                </div>
								</div>
								<button class="btn btn-primary btn-lg btn-block" type="submit">
									Enregistrer
								</button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fermer</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.modal -->
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
