<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/stylefour/js/DesignationAddForm.js'></script>
<h2>Designation (Add Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>
<form method='post' action='/stylefour/AddDesignation.jsp' onsubmit='return validateForm(this)'>
<tm:FormID/>
Designation
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<span id='titleErrorSection' style='color:red'></span><br>
<button type='submit'>Add</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>
</form>
<form id='cancelAdditionForm' action='/stylefour/DesignationsView.jsp'>
<jsp:include page='/MasterPageBottomSection.jsp'/>