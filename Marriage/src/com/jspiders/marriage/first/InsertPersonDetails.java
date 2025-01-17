package com.jspiders.marriage.first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertPersonDetails {
	Connection CON = null;
	PreparedStatement pstmt = null;

	public void insert(Person person) throws FileNotFoundException
	{
		try {
			
		Driver driverref = new Driver();
		
		DriverManager.registerDriver(driverref);
		
		String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
		   CON = DriverManager.getConnection(dburl);
		   
		  String query = " insert into person  "
				  		+ " values(?,?,?,?) ";
		  
		FileInputStream inputStream = new FileInputStream(person.getPhoto());
		  
		pstmt =   CON.prepareStatement(query);
		pstmt.setString(1, person.getName());
		pstmt.setInt(2, person.getAge());
		pstmt.setBinaryStream(3, inputStream);
		pstmt.setLong(4, person.getContact());
		
		
		int res = pstmt.executeUpdate();
		
		if(res!=0) {
			System.out.println("Record inserted");
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(CON != null)
				{
					CON.close();
				}
				
				if(pstmt!=null)
				{
					pstmt.close();
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
	
}
