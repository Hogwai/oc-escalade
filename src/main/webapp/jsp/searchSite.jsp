<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
						<a href="/lesamisdelescalade/home">Liste des sites</a>
					</li>
					<li class="breadcrumb-item active" aria-current="page">
						<a href="${request.requestURL}">Recherche de sites</a>
					</li>
				</ol>
			</nav>
			
			<div class="row">
				<div class="col-lg-12">
					<form class="my-2 px-3 pt-3 border rounded" action="${pageContext.request.contextPath}/recherchesite" method="POST">
					    <div class="form-row">
					        <div class="col-6 form-group">
					            <label class="sr-only" for="libelle">Libellé du site</label>
					            <input class="form-control" id="libelle" type="text" placeholder="Nom du site" name="libelle">
					            
					        </div>				
					    </div>
				        <h6>Filtrer par : </h6>
				        <div class="form-row">
				            <div class="col-auto form-group custom-control custom-checkbox pl-2 ml-4">
				                <input type="checkbox" class="custom-control-input" id="tag" name="tag" value="tag" />
				                <label class="custom-control-label" for="tag">Officiel "Les amis de l&#039escalade"</label>
				            </div>
				        </div>
				
				        <div class="form-row">
				            <div class="col-auto form-group">
				                <label for="departmentId">Departement</label>
				                <select class="form-control" id="departmentId" type="text" name="departmentId">
				                    <option value="" >(non renseigné)</option>
				                    <option value="1">01 - ain</option>
				                </select>
				            </div>
				        </div>
				
				        <div class="form-row">
				            <div class="col-auto form-group">
				                <label for="cotation">Difficulté</label>
				                <select class="form-control" id="cotation" type="text" name="cotation">
				                	<option value=""></option>
				                	<c:forEach var="cotation" items="${cotations}" >
					                    <option value="${cotation.id}">${cotation.libelle}</option>
				                    </c:forEach>
				                </select>
				            </div>
				
				            <div class="col-auto form-group">
				                <label for="siteTypeId">Type du site</label>
				                <select class="form-control" id="siteTypeId" type="text" name="siteTypeId">
				                	<option value=""></option>
				                </select>
				            </div>
				        </div>
				
				        <div class="form-row">
				            <div class="col-6 form-group">
				                <label for="levelGroupId">Niveau recommandé</label>
				                <select class="form-control" id="levelGroupId" type="text" name="levelGroupId">
				                    <option value="">(non renseigné)</option>
				                    <option value="1">Débutants (suffisamment de voies de 3a à 5c)</option>
				                    <option value="2">Amateurs (suffisamment de voies de 6a à 6c)</option>
				                    <option value="3">Confirmés (suffisamment de voies de 7a à 7c)</option>
				                    <option value="4">Pros (suffisamment de voies de 8a à 9c)</option>
				                </select>
				            </div>
				
				            <div class="col-3 form-group" >
				                <label for="routesNumberId">Nombre de voies</label>
				                <select class="form-control" id="routesNumberId" type="text" name="routesNumberId">
				                    <option value="">(non renseigné)</option>
				                    <option value="1">Moins de 10 voies</option>
				                    <option value="2">Entre 10 et 25 voies</option>
				                    <option value="3">Entre 25 et 50 voies</option>
				                    <option value="4">Entre 50 et 100 voies</option>
				                    <option value="5">Entre 100 et 200 voies</option>
				                    <option value="6">Entre 200 et 500 voies</option>
				                    <option value="7">Plus de 500 voies</option>
				                </select>
				            </div>
				
				            <div class="col-3 form-group">
				                <label for="minRouteHeight">Hauteur minimum (en m)</label>
				                <input class="form-control" id="minRouteHeight" type="text" placeholder="Hauteur minimum en mètre" value="minRouteHeight" name="minRouteHeight">
				            </div>

				        </div>
			            <button class="btn btn-primary btn-lg btn-block mb-2" type="submit">Rechercher</button>
					</form>
				</div>
			</div>
			
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-hover">
						<caption>Résultats de recherche des sites</caption>
						<thead>
							<tr>
								<th scope="col">Numéro</th>
								<th scope="col">Libellé</th>
								<th scope="col">Hauteur (mètres)</th>
								<th scope="col">Officiel "Les Amis de l'Escalade"</th>
								<th scope="col">Ville</th>
								<th scope="col">Pays</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="site" items="${sites}" >
								<tr onclick="window.location='${pageContext.request.contextPath}/site?siteId=${site.id}'">
									<th scope="row">${site.id}</th>
									<td>${site.libelle}</td>
									<td>${site.hauteur}</td>
									<td>${site.tagYN eq 1 ? "Oui"  : "Non"} </td>
									<td>${site.ville}</td>
									<td>${site.pays}</td>
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
	
		<script type="text/javascript">
			$('.card-img-top').each(function() {
			    
			    var num = Math.floor(Math.random() * 5 + 1),
			        img = $(this);
			    
			    img.attr('src', '${pageContext.request.contextPath}/img/site_card/site_card_'+num+'.jpg');
			    img.attr('alt', 'src: '+img.attr('src'));
			    
			});
		</script>
	</body>
</html>
