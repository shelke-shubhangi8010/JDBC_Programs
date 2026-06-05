package com.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareStmtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			// step -1 Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db ", "root", "root");

			// step =3 Creatye Statement
			PreparedStatement pst = con.prepareStatement("insert into person values(?,?,?)");
			pst.setInt(1, 103);
			pst.setString(2, "Shubhangi");
			pst.setInt(3, 40);

			// Step- 4 Excecute Query

			int i = pst.executeUpdate();
			System.out.println(i + "Data Inserted Successfully");

			// step = 5 close Connection
			con.close();

		} catch (Exception e) {

			System.out.println(e);
		}

	}

}


