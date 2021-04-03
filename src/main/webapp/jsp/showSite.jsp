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
					<li class="breadcrumb-item active" aria-current="page">Accueil</li>
				</ol>
			</nav>
					
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<c:forEach var="site" items="${sites}" >
						    <div class="col-lg-4 col-md-6 mb-4">
								<div class="card h-100">
									<a href="#">
										<img class="card-img-top" width="100" height="250"alt="">
									</a>
									<div class="card-body">
										<h4 class="card-title">
											<a href="site?siteId=${site.id}">Site: <c:out value="${site.id}" /></a>
										</h4>
										<p class="card-text">Libellé: <c:out value="${site.libelle}" /></p>
									</div>
									<div class="card-footer">
										<small class="text-muted">
											Commentaires: ${fn:length(site.commentaires)}
										</small>
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
				<!-- /.col-lg-9 -->
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
