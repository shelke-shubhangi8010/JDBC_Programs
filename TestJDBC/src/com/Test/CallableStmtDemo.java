package com.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {

			// step -1 Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db ", "root", "root");

			// step =3 Create Statement
			//CallableStatement cst =con.prepareCall("{call delete_from_person (?) }");
			CallableStatement cst =con.prepareCall("{call delete_from_person_name(?)}");
			cst.setString(1,"Mayuri ");
			
			
			// Step- 4 Execute Query
			cst.execute();
			System.out.println("Deletion Successfully");
			// step = 5 close Connection
			con.close();

		} catch (Exception e) {

			System.out.println(e);
		}
		
		
	}

}
 // procedure for callable statement


/*
 * mysql> use jdbc_db;
Database changed
mysql> show tables;
+-------------------+
| Tables_in_jdbc_db |
+-------------------+
| person            |
+-------------------+
1 row in set (0.01 sec)

mysql> select * from person;
Empty set (0.01 sec)

mysql> select * from person;
+------+-----------+------+
| id   | name      | age  |
+------+-----------+------+
|  101 | shubhangi |   20 |
+------+-----------+------+
1 row in set (0.00 sec)

mysql> select * from person;
+------+-----------+------+
| id   | name      | age  |
+------+-----------+------+
|  101 | shubhangi |   20 |
|  102 | Mayuri    |   70 |
+------+-----------+------+
2 rows in set (0.00 sec)

mysql> delimiter //
mysql> create procedure  delete_from_person(in no int)
    -> begin
    -> delete from person where id = no;
    -> end//
Query OK, 0 rows affected (0.03 sec)

mysql> select * from person;
    -> //
+------+--------+------+
| id   | name   | age  |
+------+--------+------+
|  102 | Mayuri |   70 |
+------+--------+------+
1 row in set (0.00 sec)

 

 */
