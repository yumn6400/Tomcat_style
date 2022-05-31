package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
public class LoggedInTagHandler extends TagSupport
{
public LoggedInTagHandler()
{
reset();
}
private void reset()
{
// do nothing
}
public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
HttpSession session=request.getSession();
String id =(String)session.getAttribute("uid");
if(id==null)
{
return super.EVAL_BODY_INCLUDE;
}
return super.SKIP_BODY;
}
public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}
}