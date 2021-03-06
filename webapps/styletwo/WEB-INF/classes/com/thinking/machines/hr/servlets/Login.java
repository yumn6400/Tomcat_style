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
AdministratorBean administratorBean=(AdministratorBean)request.getAttribute("AdministratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=administratorBean.getUsername();
String password=administratorBean.getPassword();
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorDTO administratorDTO=null;
try
{
administratorDTO=administratorDAO.getByUsername(username);
String pwd=administratorDTO.getPassword();
if(pwd.equals(password)==false)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username or password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
HttpSession session=request.getSession();
session.setAttribute("username","username");
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
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