<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (Delete Module)</h2>
<script src='/stylefour/js/ConfirmDeleteDesignation.js'></script>
<b>Title: ${designationBean.title}</b>
<form method='post' action='/stylefour/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<button type='submit'>Delete</button>
<button type='Button' onclick='cancelAddition()'>Cancel</button>
</form>
<form id='cancelAdditionForm' action='/stylefour/DesignationsView.jsp'>
<jsp:include page='/MasterPageBottomSection.jsp'/>