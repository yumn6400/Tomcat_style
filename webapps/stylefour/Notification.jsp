<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2> ${messageBean.heading}</h2>
${messageBean.message}
<tm:If condition='${messageBean.generateButtons}'>
<table>
<tr>
<td>
<form action='/stylefour/${messageBean.buttonOneAction}'>
<button type='submit'>${messageBean.buttonOneText}</button>
</form>
</td>
<tm:If condition='${messageBean.generateTwoButtons}'>
<td>
<form action='/stylefour/${messageBean.buttonTwoAction}'>
<button type='submit'>${messageBean.buttonTwoText}</button>
</form>
</td>
</tm:If>
</tr>
</table>
</tm:If>
<jsp:include page='/MasterPageBottomSection.jsp'/>