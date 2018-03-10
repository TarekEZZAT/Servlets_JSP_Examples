<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ page 
			language="java"
			contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1"
			import="fr.uitt.biblio.modele.Livre,java.util.Iterator"		
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
	
	<FORM action=<%= response.encodeURL("CtrlPrincipal?page=2")%> method="post" name="login">
	<!--
		<input type="hidden" name="page" value="2">
	-->
	<TABLE border="1" align="center">
		<TR>
			<TD>Titre livre : </TD>
			<TD><INPUT type="text" name="titreLivre" size="20"></TD>
		</TR>
		<TR>
			<TD>Catégorie du livre</TD>
			<TD>
				<select name="categorieLivre">
				  <option>Thriller</option>
				  <option>Roman</option>
				  <option>Bande dessinn&eacute;e</option>
				  <option>Histoire</option>
				</select>
		</TD>
		</TR>
		<TR>
			<TD colspan="2" align="center">
				<INPUT type="submit" name="reserver" value="Reserver">
			</TD>
		</TR>
	</TABLE>
	</FORM>
	<h2 align="center">Liste des Livres déjà réservés</h2>
	<jsp:useBean id="adherent"  type="fr.uitt.biblio.modele.IAdherent" scope="session"/>
	<!-- marche avec toString surchargé
	-->
	<jsp:getProperty name="adherent" property="listeLivres"/>
	
	
	<FORM action="#" method="post" name="frmIdentification">

	<TABLE border="1" align="center" >
		<TR bgcolor="silver">
			<TD width="150"><b>Titre</b></TD>
			<TD width="100"><b>Catégorie</b></TD>
		</TR>
		<% // je boucle sur les livres
			Iterator iter = adherent.getListeLivres().iterator();
			while (iter.hasNext()){
				Livre unLivre = (Livre)iter.next();%>
				<TR>
					<TD>&nbsp;<%= unLivre.getTitreLivre () %></TD>
					<TD>&nbsp;<%= unLivre.getCategorieLivre() %></TD>
				</TR>

		<%}	%>
	</TABLE>
	</FORM>
	<p align="right"><A	href=<%= response.encodeURL("CtrlPrincipal?page=2")%>>Déconnexion</A></p>
	<jsp:include page="piedpage.jsp" flush="true" />
</body>
</html>
