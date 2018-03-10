<%@ taglib uri="/tld" prefix="tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<%@ page 
			language="java"
			contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1"
			import="fr.uitt.biblio.modele.Livre,fr.uitt.biblio.modele.IAdherent,java.util.Iterator"		
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
			<tld:iteration var="unLivre"  type="fr.uitt.biblio.modele.Livre" liste="<%=adherent.getListeLivres()%>" >
				<tr>
					<td>
						<jsp:getProperty name="unLivre" property="titreLivre" />
					</td>
					<td>
						<jsp:getProperty name="unLivre" property="categorieLivre" />
					</td>
				</tr>
			</tld:iteration>
		
		</tbody>
	
	</table>
	</form>
	<p align="center"> Vous avez réservé <%=pageContext.getAttribute("nbElements")%> livre(s)</p>.
	<p align="right"><a	href='<%= response.encodeURL("CtrlPrincipal?page=2")%>'>Déconnexion</a></p>
	<jsp:include page="piedpage.jsp" flush="true" />
</body>
</html>
