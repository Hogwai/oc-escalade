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
						<a href="/lesamisdelescalade/home">Accueil</a>
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
					            <label for="libelle">Libellé du site</label>
					            <input class="form-control" id="libelle" type="text" placeholder="Nom du site" name="libelle">
					            
					        </div>				
    				        <div class="col-6 form-group">
				                <label for="hauteur">Hauteur maximale (mètres)</label>
				                <input class="form-control" id="hauteur" type="number" placeholder="Hauteur maximale" name="hauteur" min="0">
				            </div>
					    </div>
				        <div class="form-row">
				        	<div class="col-6 form-group">
				                <label for="ville">Ville</label>
				                <select class="custom-select form-control" id="ville" type="text" name="ville">
				                	<option value=""></option>
				                	<c:forEach var="vp" items="${villePays}" >
					                    <option value="${vp.key}">${vp.key} - ${vp.value}</option>
				                    </c:forEach>
				                </select>
				            </div>
				            <div class="col-6 form-group">
				            	<div class="custom-control custom-checkbox mt-5">
				                <input type="checkbox" class="custom-control-input" id="tagYN" name="tagYN" />
				                <label class="custom-control-label" for="tagYN">Officiel "Les amis de l&#039escalade"</label>
				                </div>
				            </div>
				        </div>
						<hr class="solid">
				        <div class="form-row">
							<div class="col-6 form-group">
				                <label for="nbSecteurs">Nombre maximal de secteurs</label>
				                <input class="form-control" id="nbSecteurs" type="number" placeholder="Nombre de secteurs" name="nbSecteurs" min="1">
				            </div>
				            <div class="col-6 form-group">
				                <label for="nbVoies">Nombre maximal de voies</label>
				                <input class="form-control" id="nbVoies" type="number" placeholder="Nombre de voies" name="nbVoies" min="1">
				            </div>
				        </div>
				
				        <div class="form-row">
							<div class="col-6 form-group">
				                <label for="nbLongueurs">Nombre maximal de longueurs</label>
				                <input class="form-control" id="nbLongueurs" type="number" placeholder="Nombre de longueurs" name="nbLongueurs" min="1">
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
								<th scope="col">Secteurs</th>
								<th scope="col">Voies</th>
								<th scope="col">Longueurs</th>
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
									<td>${fn:length(site.secteurs)}</td>
									<td>${site.sumOfVoies()}</td>
									<td>${site.sumOfLongueurs()}</td>
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
