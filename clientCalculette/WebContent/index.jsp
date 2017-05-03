<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calcul</title>
</head>
<body>
	<form action="CalculServlet?essai=ajouter" method="get" >
		X: <input type="text" name="x" /><br /> Y: <input type="text"
			name="y" /><br />
		<button>valider</button>
	</form>
	<c:if test="${!empty(resultat) }">
		Resultat addition = ${resultat }<br />
		Resultat soustraction = ${resultat2 }<br />
		Resultat division = ${resultat3 }<br />
		Resultat multiplication = ${resultat4 }<br />
		
	</c:if>
</body>
</html>