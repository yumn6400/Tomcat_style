<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
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

<div class='loginForm'>
<form action='/styletwo/Login.jsp' method='post'>
<table border='0'>
<tr>
<td colspan='2' align='center'>
<span class='error'>
${errorBean.error}
</span>
</td>
</tr>


<tr>
<td>Username</td>
<td><input type='text' id='username' name='username' maxlength='15'></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' id='password' name='password' maxlength='15'></td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Login</button>
</td>
</tr>

</table>


</form>
</div>

</div><!-- Container section ends here -->
<!-- Footer starts here -->
<div class='footer'>
&copy; Thinking Machines 2022
</div><!-- Footer ends here -->
</div> <!-- Main container ends here -->
</form>
</body>
</html>