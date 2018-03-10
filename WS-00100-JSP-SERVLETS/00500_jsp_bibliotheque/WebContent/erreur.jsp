<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" 
		isErrorPage="true" 
		import="java.io.*" 
		errorPage="erreur.html"%>
<html>
<head>
	<title>Erreur <%= exception.getMessage() %> - Bibliothèque en ligne</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="GENERATOR" content="IBM WebSphere Studio">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv='Pragma' content='no-cache'>
	<link href="theme/Master.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="entete.html" %>
	
	<h1 align="center">Erreur <%= exception.getClass() %></h1>
	
	<h4 align="center">Une erreur est survenue durant le traitement de votre demande: 
	   <%= request.getRequestURI() %> 
	
	<b>Message : </b>
	<%= exception.getMessage() %>
	</h4>
	
	<jsp:include page="piedpage.jsp" flush="true" />
	
</body>
</html>
