package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MetaDateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");

		 // step : 3 Create SQL statement
			   PreparedStatement p = con.prepareStatement("select * from person");


		// step: 4  Execute  SQL Statement
			 ResultSet rs= p.executeQuery();
			 ResultSetMetaData rmd=rs.getMetaData();

			 System.out.println("Total no of columns :" +rmd.getColumnCount());
			 System.out.println("Name of 1st Column :" +rmd.getColumnName(1));
			 System.out.println("types of  1st column  :" +rmd.getColumnTypeName(1));
			 
		 // step : 5  close connection
			  con.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
