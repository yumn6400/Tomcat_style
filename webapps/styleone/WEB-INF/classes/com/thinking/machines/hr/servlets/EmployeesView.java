package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;
import com.thinking.machines.hr.dl.*;
public class EmployeesView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
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
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}