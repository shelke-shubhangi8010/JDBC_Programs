package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*    Delimiter //
mysql> create procedure Area_of_Circle(In radius double,out area double)
   -> begin
   -> set area = 3.14*radius*radius;
   -> end //
Query OK, 0 rows affected (0.03 sec)
*/
public class Callable_Area_of_Circle {
	public static void main(String[] args) {
		
		try
		{
		//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");

		 // step : 3 Create SQL statement
			  CallableStatement cs=con.prepareCall("{call Area_of_Circle(?,?)}");
			   cs.setDouble(1,7);
			   cs.registerOutParameter(2, Types.DOUBLE);
			  
		// step: 4  Execute  SQL Statement
			 cs.execute();

			    System.out.println("Area of Circle : "+cs.getDouble(2));

		 // step : 5  close connection
			  con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}

}
