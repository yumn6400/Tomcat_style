package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String title="";
PrintWriter pw=null;
try
{
title=request.getParameter("title");
if(title==null||title.length()==0)
{
return;
}
pw=response.getWriter();
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
designationDAO.add(designationDTO);

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
pw.println("<h2> Notification</h2>");
pw.println("<h4>Designation Added</h4>");
pw.println("Add More<br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/addDesignation.html'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/designationsView'>");
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
pw.println("<form id='cancelAdditionForm' action='/styleone/designationsView'>");
pw.println("</form>");
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
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div><!-- Left panel ends here -->");
pw.println("<!-- Right panel starts here -->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-botton:5px;padding:5px;border:1px solid black'>");
pw.println("<h2>Designation (Add Module)</h2>");
pw.println("<div style='color:red'>"+exception.getMessage()+"</div>");
pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation");
pw.println("<input type='text' id='title' name='title' maxlength='35' size='36'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit' style='float:left'>Add</button>");
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
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");

}



}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

}