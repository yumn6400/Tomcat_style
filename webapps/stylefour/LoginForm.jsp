<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<jsp:useBean id='administrationBean' scope='request' class='com.thinking.machines.hr.beans.AdministrationBean'/>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR application</title>
<script>
function preventBack() { window.history.forward(); }
setTimeout("preventBack()", 0);
window.onunload = function () { null };
function validateForm(frm)
{
var username=frm.username.value.trim();
var password=frm.password.value.trim();
var flag=true;
var firstFocus=false;
var usernameErrorSection=document.getElementById('usernameErrorSection');
usernameErrorSection.innerHTML='';
var passwordErrorSection=document.getElementById('passwordErrorSection');
passwordErrorSection.innerHTML='';
if(username.length==0)
{
usernameErrorSection.innerHTML='required';
firstFocus=true;
frm.username.focus();
flag=false;
}
if(password.length==0)
{
passwordErrorSection.innerHTML='required';
if(!firstFocus)frm.password.focus();
flag=false;
}
return flag;
}

</script>
</head>
<body>
<!-- Main container starts here -->
<div style='width:90hw;height:auto;border: 1px solid black'>
<!-- header starts here -->
<div style='margin:5px;width:90hw;height:auto;border: 1px solid black'>
<img src='/styleone/images/logo.png'style='float:left'>
<div style='margin-top:9px;margin-botton:9px;font-size:28pt'>ABS COMPANY</div>
</div> <!-- header ends here -->
<!-- Container section starts here -->
<div style='width:90hw;height:70vh;margin:5px;border: 1px solid white'>
<!-- Inner panel starts here -->
<div style='height:65vh;margin-left:5px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>
<center>
<h1>Administration</h1>
<form method='post' style='margin-left:380px;margin-right:380px;border:1px solid black;padding:20px;' action='/stylefour/Login.jsp' onsubmit='return validateForm(this)'>
<span style='color:red'>${errorBean.error}</span><br>
Username  
<input type='text' id='username' name='username' value='${administratorBean.username}' maxlength='20'>
<span style='color:red' id='usernameErrorSection'></span><br><br>
Password  
<input type='password' id='password' name='password' value='${administratorBean.password}'  maxlength='20'>
<span style='color:red' id='passwordErrorSection'></span><br><br><br>
<button type='submit'>Login</button>
</form>
</center>
</div><!-- Inner panel ends here -->
</div><!-- Container section ends here -->
<!-- Footer starts here -->
<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>
&copy; ABS Company 2022
</div><!-- Footer ends here -->
</div> <!-- Main container ends here -->
</body>
</html>