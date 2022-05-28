package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class bbb extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
String city=request.getParameter("city");
System.out.println("Name: "+name);
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Second Web Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h1>Data Saved</h1><br>");
pw.println("<h3>Name: "+name+"</h3>");
pw.println("<h3>City: "+city+"</h3>");
pw.println("<form action='/two/index.html'>");
pw.println("<button type='submit'>Ok</button>");
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