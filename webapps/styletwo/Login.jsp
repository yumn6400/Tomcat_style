<jsp:useBean id='AdministratorBean' scope='request' class='com.thinking.machines.hr.beans.AdministratorBean'/>
<jsp:setProperty name='AdministratorBean' property='*'/>
<jsp:forward page='/login'/>