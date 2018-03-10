<%@ page import="java.util.Date,java.text.DateFormat"  session="false"%>
<hr>
<p align="center">Dernière accès : 
	<%= DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM ).format(new Date ()) %><br>
</p>
