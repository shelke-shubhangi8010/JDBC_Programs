package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingDEmo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");
           con.setAutoCommit(false);
		 // step : 3 Create SQL statement
			   Statement st=con.createStatement();
			   
			   // step : 4   Execute SQL statement
			   
			   st.addBatch("insert into person(id, name, age) values(101, 'John',23)");
			   st.addBatch("insert into person(id, name, age) values(102, 'Rahul',22)");
			   st.addBatch("insert into person(id, name, age) values(103, 'Aniket',18)");
			   st.addBatch("insert into person(id, name, age) values(104, 'Rushi',56)");
			   
			   /// step: 5   close connection
			   st.executeBatch();
			   System.out.println("Records Inserted");
			   con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
