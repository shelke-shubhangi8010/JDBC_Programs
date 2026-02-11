package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Callable_ex_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{

		//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");

		 // step : 3 Create SQL statement
			  CallableStatement cs=con.prepareCall("{call factorial_number1(?,?)}");
			   cs.setInt(1, 25);
			   cs.registerOutParameter(2, Types.INTEGER);
			   

		// step: 4  Execute  SQL Statement
			 cs.execute();

			    System.out.println("factorial of number : "+cs.getInt(2));

		 // step : 5  close connection
			  con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		
		
		
		
	}

}
