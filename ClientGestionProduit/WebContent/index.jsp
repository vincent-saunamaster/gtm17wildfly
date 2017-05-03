<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GestionProduit</title>
</head>
<body>

	<c:if test="${listProduit == null }">
		<c:redirect url="GestionProduit"></c:redirect>
	</c:if>

	<section class="row">

	<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
		<form action="GestionProduit" method="get">
			<fieldset>
				<legend>ajouter un produit</legend>
				<button type="button" class="btn btn-primary">ajouter</button><hr />
				<input type="hidden" name="ajouter" value="ok" /> <label for="nom">nom</label><input
					class="form-control" type="text" name="nom" /> <label
					for="quantite">quantité</label><input class="form-control"
					type="text" name="quantite" /> <label for="prix">prix</label><input
					class="form-control" type="text" name="prix" />
			</fieldset>
		</form>
	</div>
	<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
		<form action="GestionProduit" method="get">
			<fieldset>
				<legend>modifier un produit</legend>
				<button type="button" class="btn btn-warning">modifier</button><hr />
				<input type="hidden" name="modifier" value="ok" /> <label for="id">id</label><input
					class="form-control" type="text" name="id" /> <label for="nom">nom</label><input
					class="form-control" type="text" name="nom" /> <label
					for="quantite">quantité</label> <input class="form-control"
					type="text" name="quantite" /> <label for="prix">prix</label><input
					class="form-control" type="text" name="prix" />
			</fieldset>
		</form>
	</div>
	<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
		<form action="GestionProduit" method="get">
			<fieldset>
				<legend>supprimer un produit</legend>
				<button type="button" class="btn btn-danger">supprimer</button><hr />
				<label for="id">id</label><input type="hidden" name="supprimer"
					value="ok" /> <input class="form-control" type="text" name="id" />
			</fieldset>
		</form>
	</div>
	</section>

	<section class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

		<h3>Liste des Produits</h3>

		<c:choose>

			<c:when test="${empty(listProduit)}">
				<c:out value="Aucun Produit"></c:out>
			</c:when>

			<c:otherwise>
				<table class="table table-bordered table-striped table-condensed">
					<tr>
						<th>id</th>
						<th>nom</th>
						<th>quantité</th>
						<th>prix</th>
					</tr>
					<c:forEach var="produit" items="${listProduit }">
						<tr>
							<td><c:out value="${produit.id }"></c:out></td>
							<td><c:out value="${produit.nom }"></c:out></td>
							<td><c:out value="${produit.quantite }"></c:out></td>
							<td><c:out value="${produit.prix }"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>

		</c:choose>
	</div>
	</section>
</body>
</html>