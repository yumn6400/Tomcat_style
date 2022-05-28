<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:LoggedIn>
<jsp:forward page='/LoginForm.jsp'/>
</tm:LoggedIn>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR application</title>
<link rel='stylesheet' type='text/css' href='/stylethree/css/Styles.css'>
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
<a href='/stylethree/index.jsp'><img src='/stylethree/images/logo.png' class='logo'></a>
<div class='brand-name'>Thinking Machines
<div style='float:right;font-size:15pt;'><img src='/stylethree/images/main-user.png'>
<%
String username=(String)session.getAttribute("username");
%>
<%=username%>
&nbsp;&nbsp;&nbsp;&nbsp;
<span style='font-size:14pt;'><a href='/stylethree/logout'>Logout</a><span>
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
<a href='/stylethree/Designations.jsp'>Designations</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/stylethree/employeesView.jsp'>Employees</a><br><br>
</tm:If>

<tm:If condition='${module!=HOME}'>
<a href='/stylethree/index.jsp'>Home</a>
</tm:If>


</div><!-- Left panel ends here -->
<!-- Right panel starts here -->
<div class='content-right-panel'>