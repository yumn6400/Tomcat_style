package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
public class UpdateDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int code=0;
String title="";
response.setContentType("text/html");
PrintWriter pw=null;
try
{
pw=response.getWriter();
title=request.getParameter("title");
if(title==null)
{
sendBackView(response);
return;
}
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException nfe)
{
sendBackView(response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
designationDAO.getByCode(code);
if(title.length()==0)
{
throw new DAOException("Length of title is zero");
}
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setCode(code);
designationDTO.setTitle(title);
designationDAO.update(designationDTO);
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
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h1> Designation(Update Module)</h1>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<h2> Designation updated</h2>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");
}catch(Exception exception)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML='required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("function cancelEditing()");
pw.println("{");
pw.println("document.getElementById('cancelEditingForm').submit();");
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
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Designation(Update Module)</h2>");
pw.println("<div style='color:red'>"+exception.getMessage()+"</div>");
pw.println("<form method='post' action='/styleone/updateDesignation' onsubmit='return validateForm(this)'>");
pw.println("<input type='hidden' id='code' name='code' value='"+code+"'><br>");
pw.println("Title");
pw.println("<input type='text' id='title' name='title' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>Update</button>");
pw.println("<button type='Button' onclick='cancelEditing()'>Cancel</button>");
pw.println("</form>");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("<form id='cancelEditingForm' action='/styleone/designationsView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
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
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designations=designationDAO.getAll();
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
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
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png'style='float:left'></a>");
pw.println("<div style='margin-top:9px;margin-botton:9px;font-size:28pt'>Thinking Machines</div>");
pw.println("</div> <!--header ends here -->");
pw.println("<!-- Container section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border: 1px solid white'>");
pw.println("<!-- Left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border: 1px solid black'>");
pw.println("<b>Designations</b><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;overflow:scroll;border:1px solid black'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'><a href='/styleone/addDesignation.html'>Add new Designation</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.no.</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

int x;
int code;
String title;
int sno=0;
DesignationDTO designationDTO;
for(x=0;x<designations.size();x++)
{
sno++;
designationDTO=designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+"</td>");
pw.println("<td >"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div><!-- Right panel ends here -->");
pw.println("</div><!-- Container section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;text-align:center;border:1px solid white'>");
pw.println("&copy; Thinking Machines 2022");
pw.println("</div><!-- Footer ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException e)
{
System.out.println(e.getMessage());
}
catch(IOException ie)
{
System.out.println(ie.getMessage());
}
}
}