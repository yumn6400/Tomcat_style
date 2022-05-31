<jsp:useBean id='AdministrationBean' scope='request' class='com.thinking.machines.hr.beans.AdministrationBean'/>
<jsp:setProperty name='AdministrationBean' property='*'/>
<jsp:forward page='/login'/>