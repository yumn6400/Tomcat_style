package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
public class ccc extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
Cookie cookies[]=request.getCookies();
HttpSession ss=request.getSession();
String name=(String)ss.getAttribute("name");
String city=(String)ss.getAttribute("city");
System.out.println("Name: "+name);
System.out.println("City: "+city);
try
{
name=URLDecoder.decode(name);
city=URLDecoder.decode(city);
}catch(Exception e)
{
System.out.println(e);
}
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Fifth Web Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h1>Data Saved</h1><br>");
pw.println("<h3>Name: "+name+"</h3>");
pw.println("<h3>City: "+city+"</h3>");
pw.println("<form action='/five/index.html'>");
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