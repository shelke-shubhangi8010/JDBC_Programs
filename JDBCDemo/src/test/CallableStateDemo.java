package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CallableStateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try 
		{

		//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");
			    
		 // step : 3 Create SQL statement
			  CallableStatement cs=con.prepareCall("{call delete_By_id(?)}");
			   cs.setInt(1, 104);
			   
		// step: 4  Execute  SQL Statement
			 cs.execute();
			    
			    System.out.println("deletion successfully");
			    
		 // step : 5  close connection
			  con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
