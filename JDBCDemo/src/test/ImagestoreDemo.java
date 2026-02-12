package test;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
public class ImagestoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
			//step : 1 Register Driver
			  Class.forName("com.mysql.cj.jdbc.Driver");

		 // step :  2 Create connection
			    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB","root","root");

		 // step : 3 Create SQL statement
			   PreparedStatement pst = con.prepareStatement("insert into imagedb(name,profile_pic) values(?,?)");
			   pst.setString(1, "Ramdome Image");
			   
			   FileInputStream input= new FileInputStream(new String("C:\\java img\\Flower.jpg"));
					 pst.setBinaryStream(2, input ) ; 
			// step : 4 Execute Query
					 int rs=pst.executeUpdate();
			// Display Result
					 
					 if(rs>0)
					 {
						 System.out.println("Data Inserted Successfully");
					 }
				// step 5: close connection
					   input.close();
			          
					   
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		
	}

}

/*
 * 
 * mysql> use javadb;
Database changed
mysql> show tables;
+------------------+
| Tables_in_javadb |
+------------------+
| imagedb          |
| person           |
+------------------+
2 rows in set (0.02 sec)

mysql> select * from imagedb;
 * 
 * 
 * */


