package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddDesignation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
String title=designationBean.getTitle();
DesignationDTO designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.add(designation);
designationBean.setCode(designation.getCode());
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation(Add Module)");
messageBean.setMessage("Designation added, add more ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("DesignationsView.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
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