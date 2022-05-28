package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class AddEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
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
try
{
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);
boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
boolean aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
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
pw.println("<h2>Employee (Add Module)</h2>");
pw.println("<form method='post' action='/styleone/addEmployee' onsubmit='return validateForm(this)'>");
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


}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());//remove after testing
}


EmployeeDTO employee=new EmployeeDTO();
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
employeeDAO.add(employee);

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
pw.println("<h4>Employee Added</h4>");
pw.println("Add More<br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/getEmployeeAddForm'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/employeesView'>");
pw.println("<button type='submit'>No</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
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
//recreate form with error message at top of form
//and send back the name
}


}catch(Exception e)
{
/*
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
pw.println("<h2>Employee (Add Module)</h2>");
pw.println("<span style='color:red'>"+e.getMessage()+"</span>");
pw.println("<form method='post' action='/styleone/addEmployee' onsubmit='return validateForm(this)'>");
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

DesignationDAO designationDAO=new DesignationDAO();
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
if(code==designationCode)
{
pw.println("<option value='"+code+"' selected>"+title+"</option>");
}
else
{
pw.println("<option value='"+code+"'>"+title+"</option>");
}
}
pw.println("</select>");
pw.println("<span id='designationCodeErrorSection' style='color:red'></span><br>");
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
if(gender.charAt(0)=='M')
{
pw.println("<td><input type='radio' id='male' name='gender' value='M' checked>Male");
pw.println("<input type='radio' id='female' name='gender' value='F'>Female");
}
else
{
pw.println("<td><input type='radio' id='male' name='gender' value='M'>Male");
pw.println("<input type='radio' id='female' name='gender' value='F' checked>Female");
}
pw.println("&nbsp;&nbsp;&nbsp;");
pw.println("<span id='genderErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Is Indian ?</td>");
pw.println("<td>");
if(isIndian)
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
pw.println("<input type='text' id='basicSalary' name='basicSalary' value='"+basicSalary+"'>");
pw.println("<span id='basicSalaryErrorSection' style='color:red'></span><br>");
pw.println("</td>");
pw.println("<tr>");
pw.println("<td>PAN Number </td>");
pw.println("<td>");
pw.println("<input type='text' id='panNumber' name='panNumber'>");
pw.println("<span id='panNumberErrorSection' style='color:red'></span><br>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number </td>");
pw.println("<td>");
pw.println("<input type='text' id='aadharCardNumber' name='aadharCardNumber'>");
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'><span><br>");
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
*/
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}