package com.thinking.machines.hr.beans;
public class AdministrationBean implements java.io.Serializable
{
private String username;
private String password;
public AdministrationBean()
{
this.username="";
this.password="";
}
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
}