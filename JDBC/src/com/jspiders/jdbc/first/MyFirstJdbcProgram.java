package com.jspiders.jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJdbcProgram {

	public static void main(String[] args) {
		Connection CON = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/bejm37?user=root&password=root";
		     CON = DriverManager.getConnection(dburl);
			
		/*	jdbc:mysql://[host][,failoverhost...][:port]/[database] �
			[?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]...
		*/
			
			String query = " select * from studentsinfo ";
		    stmt	= CON.createStatement();
		     rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int regNum = rs.getInt("regno");
				String fname = rs.getString("firstname");
				String mname = rs.getString("midlename");
				String lname = rs.getString("lastname");
				
				System.out.println("regNum : " + regNum);
				System.out.println("firstname : " +fname);
				System.out.println("middlename : " + mname);
				System.out.println("lastname : " + lname);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}finally {
			
			try {
				if(CON != null)
				{
					CON.close();
				}
				if(rs!= null)
				{
					rs.close();
				}
				
				if(stmt!=null)
				{
					stmt.close();
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
}
