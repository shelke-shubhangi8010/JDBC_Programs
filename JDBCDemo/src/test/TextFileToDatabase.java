package test;
import java.io.*;
import java.sql.*;

public class TextFileToDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		        String url = "jdbc:mysql://localhost:3306/javaDB";
		        String user = "root";
		        String password = "root";

		        try {
		            // Load Driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Create Connection
		            Connection con = DriverManager.getConnection(url, user, password);

		            // Prepare Statement
		            String query = "INSERT INTO student VALUES (?, ?, ?)";
		            PreparedStatement ps = con.prepareStatement(query);

		            // Read Text File
		            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		            String line;

		            while ((line = br.readLine()) != null) {
		                String[] data = line.split(",");

		                ps.setInt(1, Integer.parseInt(data[0]));
		                ps.setString(2, data[1]);
		                ps.setInt(3, Integer.parseInt(data[2]));

		                ps.executeUpdate();
		            }

		            System.out.println("Data Inserted Successfully!");

		            br.close();
		            con.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    
		

		
		
		
		
		
	}

}
