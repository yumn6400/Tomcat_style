package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
public class IfTagHandler extends TagSupport
{
private boolean condition;
public void setCondition(boolean condition)
{
System.out.println("set condition got called");
this.condition=condition;
}
public boolean getCondition()
{
System.out.println("get condition got called");
return this.condition;
}
public IfTagHandler()
{
System.out.println("if tag handler default constructor got called");
reset();
}
private void reset()
{
this.condition=false;
}
public int doStartTag()
{
System.out.println("if : do start tag got called");
if(condition==true)return super.EVAL_BODY_INCLUDE;
return super.SKIP_BODY;
}
public int doEndTag()
{
System.out.println("if: do end tag got called");
this.reset();
return super.EVAL_PAGE;
}
}