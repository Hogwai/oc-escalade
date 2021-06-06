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
					<li class="breadcrumb-item active" aria-current="page">
						<a href="${request.requestURL}">Site n°${currentSite.id}: ${currentSite.libelle}</a>
					</li>
				</ol>
			</nav>
			
			<div class="row">
				<div class="col-lg-12">
					<div class="card mb-3">
				    	<div class="${sessionScope.utilisateur.membreAssoYN eq 0 ? 'card-body collapse' : 'card-body mb-3'}">
							<form id="modifyTag" action="/lesamisdelescalade/site?modifyTag" method="POST">
			                	<input type="hidden" id="siteId" name="siteId" value="${currentSite.id}">
			                	<div class="form-group">
			                		<div class="custom-control custom-checkbox">
										<input type="checkbox" id="tagYN" name="tagYN" 
												value="tagYN" class="custom-control-input" ${currentSite.tagYN eq 1 ? "checked='checked'"  : ""} 
												onchange="document.getElementById('modifyTag').submit()"/> 
										<label class="custom-control-label" for="tagYN">Officiel "Les amis de l&#039escalade"</label>
									</div>	
	                    		</div>
			                </form>
				    	</div>
				    	<!-- /.card-body -->
				    	
	       				<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addSecteur">
						  	Ajouter un secteur
						</button>
					</div>
					<!-- /.card mb-3 -->
					
					<div class="row">
						<c:forEach var="secteur" items="${currentSite.secteurs}" >
						    <div class="col-lg-4 col-md-6 mb-4">
								<div class="card h-100">
									<div class="card-body">
										<h4 class="card-title">
											<a href="/lesamisdelescalade/secteur?secteurId=${secteur.id}">Secteur: <c:out value="${secteur.id}" /></a>
										</h4>
										<p class="card-text">
											Libellé: <c:out value="${secteur.libelle}" />
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
					
					<div class="row">
						<!-- Commentaires -->
						<div class="col-sm-5 col-md-6 col-12 pb-4">
							<div class="card">
					            <div class="card-body text-center">
					                <h4 class="card-title">Commentaires</h4>
					            </div>
			                	<div class="comment-widgets">
					                <c:forEach var="commentaire" items="${currentSite.commentaires}" >
						                <!-- Comment Row -->
						                <div class="d-flex flex-row comment-row m-t-0 card m-2">
						                    <div class="comment-text w-100">
						                        <h6 class="font-medium"><span class="bi bi-person-circle m-2"></span>${commentaire.utilisateur.nom} ${commentaire.utilisateur.prenom}</h6> 
						                        <span class="m-b-15 d-block m-2 card">${commentaire.contenu} </span>
						                        <form action="/lesamisdelescalade/commentaire?delete" 
						                        	class="${sessionScope.utilisateur.membreAssoYN eq 0 ? 'collapse' : ''}"
						                        	method="POST">
								                	<input type="hidden" id="commentId" name="commentId" value="${commentaire.id}">
								                	<input type="hidden" id="siteId" name="siteId" value="${currentSite.id}">
								                	<div class="form-group">
							                    		<input type="submit" id="deleteComment" name="Supprimer" class="btn btn-danger btn-sm" value="Supprimer"/> 
						                    		</div>
								                </form> 
						                        <div class="comment-footer">
						                        	<form action="/lesamisdelescalade/commentaire?modify" 
						                        		class="${sessionScope.utilisateur.membreAssoYN eq 0 ? 'collapse' : ''}" 
						                        		method="POST">
									                	<input type="hidden" id="siteId" name="siteId" value="${currentSite.id}">
									                	<input type="hidden" id="commentId" name="commentId" value="${commentaire.id}">
									                	<div class="form-group">
									                		<textarea name="commentText" id="commentText" rows="1" class="form-control" required></textarea>
								                    		<input type="submit" id="editComment" name="Modifier" class="btn btn-secondary btn-sm" value="Modifier"/> 
							                    		</div>
									                </form>  
						                        </div>
						                    </div>
						                </div> 
						                <!-- Comment Row -->
									</c:forEach>
									<!-- /.forEach -->
								</div>
								<!-- /.comment-widgets -->
							</div>
							<!-- /.card -->
			            </div>
			            <!-- /.col-sm-5 col-md-6 col-12 pb-4 -->
			            
			            <div class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4">
			                <form action="/lesamisdelescalade/commentaire?add" id="algin-form" method="POST">
			                    <div class="form-group">
			                        <h4>Laisser un commentaire</h4> 
			                        <label for="commentText">Commentaire</label> 
			                        <textarea name="commentText" id="commentText" class="form-control" required></textarea>
			                    </div>
			                    <div class="form-group">
			                    	<input type="hidden" name="commentAction" id="commentAction" value="add" /> 
			                    	<input type="hidden" id="siteId" name="siteId" value="${currentSite.id}">
			                    	<input type="submit" id="post" class="btn btn-info btn-sm" name="Poster" value="Poster" /> 
		                    	</div>
			                </form>
			            </div>
			            <!-- /.Commentaires -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<!-- modal -->
			<div class="modal fade" id="addSecteur" role="dialog" aria-labelledby="addSecteurLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="addSecteurLabel">Ajouter un secteur</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form action="${pageContext.request.contextPath}/site?addSecteur" method="POST">
								<div class="form-row">
									<label for="libelleSecteur">Libellé</label> 
									<input class="form-control"
										id="libelleSecteur" type="text" placeholder="libellé du secteur"
										name="libelleSecteur" required>
									<input type="hidden" id="siteId" name="siteId" value="${currentSite.id}">
								</div>
								<button class="btn btn-primary btn-lg btn-block m-2" type="submit">
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
