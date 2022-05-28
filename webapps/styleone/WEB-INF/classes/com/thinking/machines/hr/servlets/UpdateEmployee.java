package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class UpdateEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String employeeId=request.getParameter("employeeId");
String name=request.getParameter("name");
int designationCode=Integer.parseInt(request.getParameter("designationCode"));
Date dateOfBirth=simpleDateFormat.parse(request.getParameter("dateOfBirth"));
String gender=request.getParameter("gender");
String isIndian=request.getParameter("isIndian");
if(isIndian==null)isIndian="N";
BigDecimal basicSalary=new BigDecimal(request.getParameter("basicSalary"));
String panNumber=request.getParameter("panNumber");
String aadharCardNumber=request.getParameter("aadharCardNumber");
DesignationDAO designationDAO=new DesignationDAO();
EmployeeDAO employeeDAO=new EmployeeDAO();
EmployeeDTO employeeDTO=employeeDAO.getByEmployeeId(employeeId);
if(employeeDAO.employeeIdExists(employeeId)==false)
{
sendBackView(response);
return;
}
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);

boolean panNumberExists=false;
boolean aadharCardNumberExists=false;
try
{
employeeDTO=employeeDAO.getByPANNumber(panNumber);
if(employeeDTO.getEmployeeId().equalsIgnoreCase(employeeId)==false)
{
panNumberExists=true;
}
}catch(DAOException daoException)
{
panNumberExists=false;
}


try
{
employeeDTO=employeeDAO.getByAadharCardNumber(aadharCardNumber);
if(employeeDTO.getEmployeeId().equalsIgnoreCase(employeeId)==false)
{
aadharCardNumberExists=true;
}
}catch(DAOException daoException)
{
aadharCardNumberExists=false;
}


if(designationCodeExists==false||panNumberExists==true||aadharCardNumberExists==true)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var valid=true;");
pw.println("var firstInvalidComponent=null;");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML='';");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='name required';");
pw.println("firstInvalidComponent=frm.name;");
pw.println("valid=false;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var vName='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ';");
pw.println("var e=0;");
pw.println("while(e<name.length)");
pw.println("{");
pw.println("if(vName.indexOf(name.charAt(e))==-1)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Invalid name';");
pw.println("firstInvalidComponent=frm.name;");
pw.println("valid=false;");
pw.println("break;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("}");
pw.println("var designationCode=frm.designationCode.value;");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML='';");
pw.println("if(designationCode==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='select designation';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.designationCode;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var dateOfBirth=frm.dateOfBirth.value;");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML='';");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='select date of birth';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.dateOfBirth;");
pw.println("valid=false;");
pw.println("}");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML='';");
pw.println("if(frm.gender[0].checked==false&&frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='select date of birth';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.gender;");
pw.println("valid=false;");
pw.println("}");
pw.println("var basicSalary=frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML='';");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='basic salary required';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var vSalary='0123456789.';");
pw.println("var k=0;");
pw.println("var isBasicSalaryValid=true;");
pw.println("while(k<basicSalary.length)");
pw.println("{");
pw.println("if(vSalary.indexOf(basicSalary.charAt(k))==-1)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("isBasicSalaryValid=false;");
pw.println("break;");
pw.println("}");
pw.println("k++;");
pw.println("}");
pw.println("if(isBasicSalaryValid)");
pw.println("{");
pw.println("var dot=basicSalary.indexOf('.');");
pw.println("if(dot!=-1)");
pw.println("{");
pw.println("var numberOfFractions=basicSalary.length-(dot+1);");
pw.println("if(numberOfFractions==0||numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("var panNumber=frm.panNumber.value.trim();");
pw.println("var panNumberErrorSection=document.getElementById('panNumberErrorSection');");
pw.println("panNumberErrorSection.innerHTML='';");
pw.println("if(panNumber.length==0)");
pw.println("{");
pw.println("panNumberErrorSection.innerHTML='pan number required';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.panNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("var aadharCardNumber=frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML='';");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='aadhar card number required';");
pw.println("if(!firstInvalidComponent)firstInvalidComponent=frm.aadharCardNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("if(firstInvalidComponent)firstInvalidComponent.focus();");
pw.println("return valid;");
pw.println("}");
pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelAdditionForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border: 1px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border: 1px solid black'>");
pw.println("<img src='/styleone/images/logo.png'style='float:left'>");
pw.println("<div style='margin-top:9px;margin-botton:9px;font-size:28pt'>Thinking Machines</div>");
pw.println("</div> <!-- header ends here -->");
pw.println("<!-- Container section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border: 1px solid white'>");
pw.println("<!-- Left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border: 1px solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<b>Employees</b><br><br>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employee (Update Module)</h2>");
pw.println("<form method='post' action='/styleone/updateEmployee' onsubmit='return validateForm(this)'>");
pw.println("<input type='hidden' id='employeeId' name='employeeId' value='"+employeeId+"'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>Name</td>");
pw.println("<td><input type='text' id='name' name='name' value='"+name+"'maxlength='35' size='36'>");
pw.println("<span id='nameErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Designation</td>");
pw.println("<td><select id='designationCode' name='designationCode'> ");
pw.println("<option value='-1'>&lt; Select Designation &gt;</option>");

List<DesignationDTO> designations=null;
try
{
designations=designationDAO.getAll();
}catch(DAOException exception)
{
System.out.println(exception.getMessage());
}
int code;
String title;
for(DesignationDTO designation:designations)
{
code=designation.getCode();
title=designation.getTitle();
if(code!=designationCode)
{
pw.println("<option value='"+code+"'>"+title+"</option>");
}
else
{
pw.println("<option selected value='"+code+"'>"+title+"</option>");
}
}
pw.println("</select>");
if(designationCodeExists==false)
{
pw.println("<span id='designationCodeErrorSection' style='color:red'>Invalid designation</span><br>");
}
else
{
pw.println("<span id='designationCodeErrorSection' style='color:red'></span><br>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of Birth </td>");
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+simpleDateFormat.format(dateOfBirth)+"' >");
pw.println("<span id='dateOfBirthErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Gender</td>");
if(gender.equals("M")==true)
{
pw.println("<td><input type='radio' id='male' name='gender' value='M' checked>Male");
pw.println("&nbsp;&nbsp;&nbsp;");
pw.println("<input type='radio' id='female' name='gender' value='F'>Female");
}
else
{
pw.println("<td><input type='radio' id='male' name='gender' value='M'>Male");
pw.println("&nbsp;&nbsp;&nbsp;");
pw.println("<input type='radio' id='female' name='gender' value='F' checked>Female");
}
pw.println("<span id='genderErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Is Indian ?</td>");
pw.println("<td>");
if(isIndian.equals("Y")==true)
{
pw.println("<input type='checkbox' id='isIndian' name='isIndian' checked>");
}
else
{
pw.println("<input type='checkbox' id='isIndian' name='isIndian'>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary</td>");
pw.println("<td>");
pw.println("<input type='text' id='basicSalary' name='basicSalary' value='"+basicSalary.toPlainString()+"'>");
pw.println("<span id='basicSalaryErrorSection' style='color:red'></span><br>");
pw.println("</td>");
pw.println("<tr>");
pw.println("<td>PAN Number </td>");
pw.println("<td>");
pw.println("<input type='text' id='panNumber' name='panNumber' value='"+panNumber+"'>");
if(panNumberExists)
{
pw.println("<span id='panNumberErrorSection' style='color:red'>PAN number exists</span><br>");
}
else
{
pw.println("<span id='panNumberErrorSection' style='color:red'></span><br>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number </td>");
pw.println("<td>");
pw.println("<input type='text' id='aadharCardNumber' name='aadharCardNumber' value='"+aadharCardNumber+"'>");
if(aadharCardNumberExists)
{
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'>Aadhar card number exists</span><br>");
}
else
{
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'></span><br>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("<button type='submit'>Add</button>");
pw.println("<button type='Button' onclick='cancelAddition()'>Cancel</button>");
pw.println("</form>");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("<form id='cancelAdditionForm' action='/styleone/designationsView'>");
pw.println("</form> ");
pw.println("</body>");
pw.println("</html>");
return;
}


EmployeeDTO employee=new EmployeeDTO();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
employee.setIsIndian(isIndian.equals("Y"));
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
try
{
employeeDAO.update(employee);

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border: 1px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border: 1px solid black'>");
pw.println("<img src='/styleone/images/logo.png'style='float:left'>");
pw.println("<div style='margin-top:9px;margin-botton:9px;font-size:28pt'>Thinking Machines</div>");
pw.println("</div> <!-- header ends here -->");
pw.println("<!-- Container section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border: 1px solid white'>");
pw.println("<!-- Left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border: 1px solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a></br>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h2> Notification</h2>");
pw.println("<h4>Employee Updated</h4>");
pw.println("<form action='/styleone/employeesView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("<form id='cancelAdditionForm' action='/styleone/employeesView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
//recreate form with error message at top of form
//and send back the name
}


}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
public void sendBackView(HttpServletResponse response)
{
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> employees=employeeDAO.getAll();

response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function Employee()");
pw.println("{");
pw.println("this.employeeId=\"\";");
pw.println("this.name=\"\";");
pw.println("this.designationCode=0;");
pw.println("this.designation=\"\";");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.isIndian=\"\";");
pw.println("this.basicSalary=0;");
pw.println("this.panNumber=\"\";");
pw.println("this.aadharCardNumber=\"\";");
pw.println("}");
pw.println("var selectedRow=null;");
pw.println("var employees=[];");

int i=0;
for(EmployeeDTO employeeDTO:employees)
{
pw.println("var employee=new Employee();");
pw.println("employee.employeeId=\""+employeeDTO.getEmployeeId()+"\";");
pw.println("employee.name=\""+employeeDTO.getName()+"\";");
pw.println("employee.designationCode="+employeeDTO.getDesignationCode()+";");
pw.println("employee.designation=\""+employeeDTO.getTitle()+"\";");
pw.println("employee.dateOfBirth=\""+employeeDTO.getDateOfBirth()+"\";");
pw.println("employee.gender=\""+employeeDTO.getGender()+"\";");
pw.println("employee.isIndian="+employeeDTO.getIsIndian()+";");
pw.println("employee.basicSalary="+employeeDTO.getBasicSalary()+";");
pw.println("employee.panNumber=\""+employeeDTO.getPANNumber()+"\"");
pw.println("employee.aadharCardNumber=\""+employeeDTO.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
}



pw.println("function selectEmployee(row,employeeId)");
pw.println("{");
pw.println("if(row==selectedRow)return;");
pw.println("if(selectedRow!=null)");
pw.println("{");
pw.println("selectedRow.style.background=\"white\"");
pw.println("selectedRow.style.color=\"black\"");
pw.println("}");
pw.println("row.style.background=\"#7C7B7B\"");
pw.println("row.style.color=\"black\"");
pw.println("selectedRow=row;");
pw.println("var i;");
pw.println("for(i=0;i<employees.length;i++)");
pw.println("{");
pw.println("if(employees[i].employeeId==employeeId)break;");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("document.getElementById(\"detailPanel_employeeId\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"detailPanel_name\").innerHTML=emp.name;");
pw.println("document.getElementById(\"detailPanel_designation\").innerHTML=emp.designation;");
pw.println("document.getElementById(\"detailPanel_dateOfBirth\").innerHTML=emp.dateOfBirth;");
pw.println("document.getElementById(\"detailPanel_gender\").innerHTML=emp.gender;");
pw.println("if(emp.isIndian)");
pw.println("{");
pw.println("document.getElementById(\"detailPanel_isIndian\").innerHTML=\"Yes\";");
pw.println("}else");
pw.println("{");
pw.println("document.getElementById(\"detailPanel_isIndian\").innerHTML=\"No\";");
pw.println("}");
pw.println("document.getElementById(\"detailPanel_basicSalary\").innerHTML=emp.basicSalary;");
pw.println("document.getElementById(\"detailPanel_panNumber\").innerHTML=emp.panNumber;");
pw.println("document.getElementById(\"detailPanel_aadharCardNumber\").innerHTML=emp.aadharCardNumber;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border: 1px solid black'>");
pw.println("<!-- header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border: 1px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png'style='float:left'></a>");
pw.println("<div style='margin-top:9px;margin-botton:9px;font-size:28pt'>Thinking Machines</div>");
pw.println("</div> <!--header ends here -->");
pw.println("<!-- Container section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border: 1px solid white'>");
pw.println("<!-- Left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border: 1px solid black'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<b>Employees</b><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h4>Employees</h4>");
pw.println("<div style='height:30vh;margin-left:5px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black;overflow:scroll'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right;padding:5px'><a href='/styleone/getEmployeeAddForm'>Add Employee</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.no.</th>");
pw.println("<th style='width:200px;text-align:center'>Id.</th>");
pw.println("<th style='width:200px;text-align:center'>Name</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

i=1;
for(EmployeeDTO employeeDTO: employees)
{
pw.println("<tr style='cursor:pointer' onclick='selectEmployee(this,\""+employeeDTO.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right'>"+i+"</td>");
pw.println("<td>"+employeeDTO.getEmployeeId()+"</td>");
pw.println("<td>"+employeeDTO.getName()+"</td>");
pw.println("<td>"+employeeDTO.getTitle()+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editEmployee?employeeId="+employeeDTO.getEmployeeId()+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteEmployee?employeeId="+employeeDTO.getEmployeeId()+"'>Delete</a></td>");
pw.println("</tr>");
i++;
}






pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("");
pw.println("<div style='height:17vh;margin-left:5px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<label style='background:gray;color:white'>Details</label>");
pw.println("<table border='0' width=\"100%\">");
pw.println("<tr>");
pw.println("<td>Employee Id :<span id='detailPanel_employeeId' style='margin-right:30px'></span></td>");
pw.println("<td>Name :<span id='detailPanel_name' style='margin-right:30px'></span></td>");
pw.println("<td>Designation :<span id='detailPanel_designation' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of Birth :<span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>");
pw.println("<td>Gender :<span id='detailPanel_gender' style='margin-right:30px'></span></td>");
pw.println("<td>Is Indian :<span id='detailPanel_isIndian' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic salary :<span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>");
pw.println("<td>PAN Number :<span id='detailPanel_panNumber' style='margin-right:30px'></span></td>");
pw.println("<td>Aadhar card number :<span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");



}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}