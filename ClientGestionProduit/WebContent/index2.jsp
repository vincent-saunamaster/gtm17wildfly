<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GestionProduit</title>
</head>
<body>
	<form action="GestionProduit" method="get">
		<input type="hidden" name="ajouter" value="ok" />
		nom: <input type="text" name="nom" /><br />
		quantite: <input type="text" name="quantite" /><br /> 
		prix: <input type="text" name="prix" /><br />
		<button>ajouter</button>
	</form>

	<table>
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>quantité</th>
			<th>prix</th>
		</tr>
		<c:forEach var="produit" items="listProduit">
			<tr> 
			
				<td><c:out value="${produit.nom }"></c:out></td>
				<td><c:out value="${produit.quantite }"></c:out></td>
				<td><c:out value="${produit.prix }"></c:out></td>
				 
			</tr>
		</c:forEach>
	</table>

</body>
</html>