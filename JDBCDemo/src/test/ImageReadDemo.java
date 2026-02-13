package test;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageReadDemo {

	public static <Blob> void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

			  // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");


			  // step : 3 Create SQL statement
			    PreparedStatement pst = con.prepareStatement("select * from imagedb");
			    
			   // step : 4
			    ResultSet rs= pst.executeQuery();
			    
			    if(rs.next()) 
			    {
			    	java.sql.Blob  b=  rs.getBlob(2);
			    	  byte brr[] = b.getBytes(1,(int)b.length());
			    	   FileInputStream input= new FileInputStream(new String("C:\\java img\\Flower.jpg"));
						 PrintStream out = null;
						 out.write(brr); 
						 out.close();
						 
			    	  
			    }
			    // Step : 5  close connection
			    con.close();
			    System.out.println(" image read Successfully");
			    
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
	}

}
