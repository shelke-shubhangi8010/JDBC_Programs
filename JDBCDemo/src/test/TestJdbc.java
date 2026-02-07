package test;
import java.sql.*;
public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  try {
			  //step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");
			    
			    
			  // step : 3 Create SQL statement
			    Statement st=con.createStatement();
			  // step 4: Execute SQL  comment
			  ResultSet rs= st.executeQuery("select * from person");
			 
			  while(rs.next())
			  {
				  System.out.println("Id :"+rs.getInt(1)  +"Name :"+ rs.getString(2)+"Age : "+rs.getInt(3));
			  }
			  
			  // step : 4 close Connection
			  con.close();
		  }
		catch(Exception e) 
		  {
			System.out.println(e);
		  }
		
	}

}
