package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
public class ModuleTagHandler extends TagSupport
{
private String name;
public void setName(String name)
{
System.out.println("set name got called");
this.name=name;
}
public String getName()
{
System.out.println("get name got called");
return this.name;
}
public ModuleTagHandler()
{
System.out.println("module tag handler default constructor got called");
reset();
}
private void reset()
{
this.name="";
}
public int doStartTag()
{
System.out.println("module: do start tag got called");
pageContext.setAttribute("HOME",0,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("DESIGNATION",1,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("EMPLOYEE",2,PageContext.REQUEST_SCOPE);
if(name.equalsIgnoreCase("DESIGNATION"))
{
pageContext.setAttribute("module",1,PageContext.REQUEST_SCOPE);
}
else if(name.equalsIgnoreCase("EMPLOYEE"))
{
pageContext.setAttribute("module",2,PageContext.REQUEST_SCOPE);
}
else if(name.equalsIgnoreCase("HOME"))
{
pageContext.setAttribute("module",0,PageContext.REQUEST_SCOPE);
}
else
{
pageContext.setAttribute("module",-1,PageContext.REQUEST_SCOPE);
}


return super.SKIP_BODY;
}
public int doEndTag()
{
System.out.println("module: do end tag got called");
this.reset();
return super.EVAL_PAGE;
}
}