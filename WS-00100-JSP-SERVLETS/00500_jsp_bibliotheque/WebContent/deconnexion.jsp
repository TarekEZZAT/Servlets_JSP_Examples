<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ page
		language="java" 
		errorPage="/erreur.jsp" 
		session="false" %>
		
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="GENERATOR" content="IBM WebSphere Studio">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<link href="theme/Master.css" rel="stylesheet" type="text/css">
	<title>D�connexion - Biblioth�que en ligne</title>
</head>

<body>
	<%@ include file="entete.html" %>
	<h2 align="center">
	  A bient�t. Votre session a �t� clotur�e avec succ�s
	</h2>
	<br><br><br><br><br>
	<p align="center">
		<a href="CtrlPrincipal?page=0">Se reconnecter...</a>
	</p>
	<jsp:include page="piedpage.jsp" flush="true"/>

</body>
</html>
