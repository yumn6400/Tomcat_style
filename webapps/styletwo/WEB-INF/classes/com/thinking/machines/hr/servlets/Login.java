package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministrationBean administrationBean=(AdministrationBean)request.getAttribute("AdministrationBean");
String username=administrationBean.getUsername();
String password=administrationBean.getPassword();
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