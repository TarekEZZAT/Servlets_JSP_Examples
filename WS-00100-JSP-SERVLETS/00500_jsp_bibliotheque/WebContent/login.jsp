<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
	<%@ page 
		language="java"
		contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="GENERATOR" content="IBM WebSphere Studio">
	<meta http-equiv="Content-Style-Type" content="text/css">
	<meta http-equiv='Pragma' content='no-cache'>
	<link href="theme/Master.css" rel="stylesheet" type="text/css">
	<title>Indentification Adhérent - Bibliothèque en ligne</title>
</head>
<body>
	<%@include file="entete.html" %>
	<form action=<%= response.encodeURL("CtrlPrincipal?page=1")%> method="post" name="frmIdentification">
	<!-- Si identification page par champs caché
		<input type="hidden" name="page" value="1">
	-->
	<fmt:setBundle basename="i18n/message"/>

	<fmt:setLocale value="fr" scope="application"/>
	

	<table border="1" align="center">
		<tr>
			<td> <fmt:message key="message.nomAdh" /> : </td>
			<td><input type="text" name="nomAdh" size="20" value="Alain"></td>
		</tr>
		<tr>
			<td><fmt:message key="message.motPasse" /> : </td>
			<td><input type="text" name="message.motPasse" size="20"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" name="connecter"
				value="<fmt:message key="bt.valider" />"></td>
		</tr>
	</table>
	</form>
	<jsp:include page="piedpage.jsp" flush="true" />
</body>
</html>
