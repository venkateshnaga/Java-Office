package com.employee.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection
{
	private static MyConnection myConnection =new MyConnection();
	public Connection connection;
	
	private MyConnection()
	{
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhatridb","root","root");
			
		}
		
		catch (ClassNotFoundException e) 
		{
		
			
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MyConnection getInstance()
	{
		
		return myConnection;

	}
}
