<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<a href='/styletwo/index.jsp'><img src='/styletwo/images/logo.png' class='logo'></a>
<div class='brand-name'>Thinking Machines</div>
</div> <!-- header ends here -->
<!-- Container section starts here -->
<div class='content'>
<!-- Left panel starts here -->
<div class='content-left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${module!=DESIGNATION}'>
<a href='/styletwo/DesignationsView.jsp'>Designations</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/EmployeesView.jsp'>Employees</a><br>
</tm:If>
<tm:If condition='${module!=HOME}'>
<br><br>
<a href='/styletwo/index.jsp'>Home</a><br>
</tm:If>

</div><!-- Left panel ends here -->
<!-- Right panel starts here -->
<div class='content-right-panel'>