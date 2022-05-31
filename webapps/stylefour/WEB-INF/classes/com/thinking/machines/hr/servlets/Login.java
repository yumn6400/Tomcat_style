package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
String uniqueId=UUID.randomUUID().toString();  
 HttpSession session = request.getSession();
 session.setAttribute("uid", uniqueId); 
session.setMaxInactiveInterval(2*60);
AdministrationBean administrationBean=(AdministrationBean)request.getAttribute("AdministrationBean");
String username=administrationBean.getUsername();
String password=administrationBean.getPassword();
session.setAttribute("username", username); 
System.out.println("username:"+username+" Password: "+password);
AdministrationDAO administrationDAO=new AdministrationDAO();
AdministrationDTO administrationDTO=null;
try
{
administrationDTO=administrationDAO.getByUsername(username);
String pwd=administrationDTO.getPassword();
if(pwd.equals(password))
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}
else
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username or password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception);
ErrorBean errorBean=new ErrorBean();
errorBean.setError(exception.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
}
}