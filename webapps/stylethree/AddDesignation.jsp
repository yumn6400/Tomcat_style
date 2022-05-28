<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<tm:FormResubmitted>
<jsp:forward page='/notifyFormResubmission'/>
</tm:FormResubmitted>
<jsp:setProperty name='designationBean' property='*'/>
<jsp:forward page='/addDesignation'/>