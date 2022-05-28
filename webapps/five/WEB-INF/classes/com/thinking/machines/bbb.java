package com.thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
public class bbb extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
String city=request.getParameter("city");
HttpSession ss=request.getSession();
ss.setMaxInactiveInterval(30);
ss.setAttribute("name",name);
ss.setAttribute("city",city);
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
pw.println("<h1>Data Saved</h1>");
pw.println("<h3>Name: "+name+"</h3>");
pw.println("<h3>City: "+city+"</h3>");
pw.println("<a href='/five/ccc?name="+URLEncoder.encode(name)+"&city="+URLEncoder.encode(city)+"'>Save</a>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e)
{
System.out.println(e);
}
}
}