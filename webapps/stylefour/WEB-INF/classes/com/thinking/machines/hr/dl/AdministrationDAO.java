package com.thinking.machines.hr.dl;
import java.util.*;
import java.sql.*;
public class AdministrationDAO
{
public AdministrationDTO getByUsername(String username)throws DAOException
{
try
{
System.out.println("Username:"+username);
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from Administrator where uname=?");
preparedStatement.setString(1,username);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Administrator username: "+username);
}
AdministrationDTO AdministrationDTO=new AdministrationDTO();
AdministrationDTO.setUsername(resultSet.getString("uname").trim());
AdministrationDTO.setPassword(resultSet.getString("pwd").trim());
resultSet.close();
preparedStatement.close();
connection.close();
return AdministrationDTO;
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
}





}