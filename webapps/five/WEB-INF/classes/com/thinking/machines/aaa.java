package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
System.out.println("Name: "+name);
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Fifth Web Application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var cc=frm.city.value.trim();");
pw.println("if(cc.length==0)");
pw.println("{");
pw.println("alert('City required');");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<form action='/five/bbb' onsubmit='return validateForm(this)'>");
pw.println("<input type='hidden' id='name' name='name' value='"+name+"'><br>");
pw.println("City");
pw.println("<input type='text' id='city' name='city'><br>");
pw.println("<button type='submit'>Next</button>");
pw.println("</form>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e)
{
System.out.println(e);
}
}
}