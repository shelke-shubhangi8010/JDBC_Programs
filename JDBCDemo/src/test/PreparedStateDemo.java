package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try 
		{

		//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");
			    
		 // step : 3 Create SQL statement
			   PreparedStatement pst = con.prepareStatement("insert into person values(?,?,?)");
			   pst.setInt(1, 5);
			   pst.setString(2, "jay");
			   pst.setInt(3, 29);
			   
		// step: 4  Execute  SQL Statement
			  int i= pst.executeUpdate();
			  System.out.println(i  +"Record Inserted");
		 // step : 5  close connection
			  con.close();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	}

}
