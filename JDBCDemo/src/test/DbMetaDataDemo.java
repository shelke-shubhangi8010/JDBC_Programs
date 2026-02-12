package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Types;

public class DbMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try
		{
		//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");

		 // step : 3 Create SQL statement
			  DatabaseMetaData dbdata=con.getMetaData();
			  
			  System.out.println("Driver name :"+dbdata.getDriverName());
			  System.out.println("Driver Version :"+dbdata.getDriverVersion());
			  System.out.println("Database Version :"+dbdata.getDatabaseProductVersion());
			  System.out.println("Database Nmae :"+dbdata.getDatabaseProductName());
			  System.out.println("User name :"+dbdata.getUserName());
			  System.out.println(" Url :"+dbdata.getURL());
		// step: 4  Execute  SQL Statement
			 
			  
			  
			  
		 // step : 5  close connection
			  con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
		
		
		
	}


