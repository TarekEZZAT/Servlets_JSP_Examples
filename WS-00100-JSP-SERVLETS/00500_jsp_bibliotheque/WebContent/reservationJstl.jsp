<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<%@ page 
			language="java"
			contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1"
			errorPage="/erreur.jsp" 
	%>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="GENERATOR" content="IBM WebSphere Studio">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv='Pragma' content='no-cache'>
	<link href="theme/Master.css" rel="stylesheet" type="text/css">
	<title>Réservation de livres - Bibliothèque en ligne</title>
</head>
<body>

	<%@include file="entete.html" %>
	
	<form action='<%= response.encodeURL("CtrlPrincipal?page=2")%>' method="post" name="login">
	<!--
		<input type="hidden" name="page" value="2">
	-->
	<table border="1" align="center">
		<tbody><tr>
			<td>Titre livre : </td>
			<td><input type="text" name="titreLivre" size="20"></td>
		</tr>
		<tr>
			<td>Catégorie du livre</td>
			<td>
				<select name="categorieLivre">
				  <option>Thriller</option>
				  <option>Roman</option>
				  <option>Bande dessinn&eacute;e</option>
				  <option>Histoire</option>
				</select>
		</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" name="reserver"
				value="Reserver">
			</td>
		</tr>
	</tbody></table>
	</form>
	<h2 align="center">Liste des Livres déjà réservés</h2>
	
	<jsp:useBean id="adherent"  type="fr.uitt.biblio.modele.IAdherent" scope="session"/>
	
	<!-- marche avec toString surchargé	-->
	<h4 align="center">
		<jsp:getProperty name="adherent" property="listeLivres"/>
	</h4>
	
	<form action="#" method="post" name="frmIdentification">

	<table border="1" align="center" >
		<thead>
		<tr bgcolor="silver">
			<td width="150"><b>Titre</b></td>
			<td width="100"><b>Catégorie</b></td>
		</tr>
		</thead>
	
		<tbody>
			<c:forEach items="${adherent.listeLivres}" var="unLivre" varStatus="status">
				<tr>
					<td>
						<c:out  value="${unLivre.titreLivre}"/>
					</td>
					<td>
						<c:out  value="${unLivre.categorieLivre}"/>
					</td>
				</tr>
				<c:if test="${status.last}"><c:set var="nbElements" value="${status.count}" /></c:if>
			</c:forEach>
		</tbody>
	</table>
	</form>
	<p align="center"> Vous avez réservé : <c:out value="${nbElements}">0</c:out> livre<c:if test="${nbElements> 1}">s</c:if></p>.
	<p align="right"><a	href='<%= response.encodeURL("CtrlPrincipal?page=2")%>'>Déconnexion</a></p>
	<jsp:include page="piedpage.jsp" flush="true" />
</body>
</html>
