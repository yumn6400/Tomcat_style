<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR application</title>
<script src='/styletwo/js/ConfirmDeleteDesignation.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styletwo/images/logo.png'class='logo'>
<div class='brand-name'>Thinking Machines</div>
</div> <!-- header ends here -->
<!-- Container section starts here -->
<div class='content'>
<!-- Left panel starts here -->
<div class='content-left-panel'>
<a href='/styletwo/DesignationsView.jsp'>Designations</a><br>
<a href='/styletwo/employeesView'>Employees</a>
</div><!-- Left panel ends here -->
<!-- Right panel starts here -->
<div class='content-right-panel'>
<h2>Designation (Delete Module)</h2>
<b>Title: ${designationBean.title}</b>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<button type='submit'>Delete</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>
</form>
</div><!-- Right panel ends here -->
</div><!-- Container section ends here -->
<!-- Footer starts here -->
<div class='footer'>
&copy; Thinking Machines 2022
</div><!-- Footer ends here -->
</div> <!-- Main container ends here -->
<form id='cancelAdditionForm' action='/styletwo/DesignationsView.jsp'>
</form>
</body>
</html>