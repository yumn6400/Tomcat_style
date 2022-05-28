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
String name="";
String city="";
if(cookies!=null)
{
Cookie c;
int x;
for(x=0;x<cookies.length;x++)
{
c=cookies[x];
if(c.getName().equals("name"))
{
name=c.getValue();
break;
}
}
for(x=0;x<cookies.length;x++)
{
c=cookies[x];
if(c.getName().equals("city"))
{
city=c.getValue();
break;
}
}
}
//String name=request.getParameter("name");
//String city=request.getParameter("city");
System.out.println("Name: "+URLDecoder.decode(name));
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>My Fourth Web Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h1>Data Saved</h1><br>");
pw.println("<h3>Name: "+URLDecoder.decode(name)+"</h3>");
pw.println("<h3>City: "+URLDecoder.decode(city)+"</h3>");
pw.println("<form action='/four/index.html'>");
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