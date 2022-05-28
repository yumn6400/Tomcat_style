<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title> My First web application(JSP)</title>
</head>
<body>
<%
String nn=request.getParameter("nm");
String cc=request.getParameter("ct");
%>

<%
System.out.println("Data arrived");
%>

<%=
nn
%>
<br>

<%=
cc
%>

</body>
</html>