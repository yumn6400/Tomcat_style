<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:LoggedIn>
<jsp:forward page='/LoginForm.jsp'/>
</tm:LoggedIn>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR application</title>
<link rel='stylesheet' type='text/css' href='/stylefour/css/styles.css'>
<script>
function preventBack() { window.history.forward(); }
setTimeout("preventBack()", 0);
window.onunload = function () { null };
</script>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<a href='/stylefour/index.jsp'><img src='/stylefour/images/logo.png' class='logo'></a>
<div class='brand-name'>ABS COMPANY
<div style='float:right;font-size:15pt;'><img src='/stylefour/images/male.png'>
<%
String username=(String)session.getAttribute("username");
%>
<%=username%>
&nbsp;&nbsp;&nbsp;&nbsp;
<span style='font-size:14pt;'><a href='/stylefour/logout'>Logout</a><span>
</div>
</div>

</div> <!-- header ends here -->
<!-- Container section starts here -->
<div class='content'>
<!-- Left panel starts here -->
<div class='content-left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${module!=DESIGNATION}'>
<a href='/stylefour/DesignationsView.jsp'>Designations</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/stylefour/EmployeesView.jsp'>Employees</a><br>
</tm:If>
<tm:If condition='${module!=HOME}'>
<br><br>
<a href='/stylefour/index.jsp'>Home</a><br>
</tm:If>

</div><!-- Left panel ends here -->
<!-- Right panel starts here -->
<div class='content-right-panel'>