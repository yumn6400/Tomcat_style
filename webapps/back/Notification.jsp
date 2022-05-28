<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:LoggedIn>
<jsp:forward page='/LoginForm.jsp'/>
</tm:LoggedIn>
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean'/>
<tm:Module name='DESIGNATION'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>${messageBean.heading}</h2>
${messageBean.message}
<tm:If condition='${messageBean.generateButtons}'>
<table>
<tr>
<td>
<form method='post' action='/stylethree/${messageBean.buttonOneAction}'>
<button type='submit'>${messageBean.buttonOneText}</button>
</form>
</td>
<tm:If condition='${messageBean.generateTwoButtons}'>
<td>
<form method='post' action='/stylethree/${messageBean.buttonTwoAction}'>
<button type='submit'>${messageBean.buttonTwoText}</button>
</form>
</td>
</tm:If>
</tr>
</table>
</tm:If>
<jsp:include page='/MasterPageBottomSection.jsp'/>