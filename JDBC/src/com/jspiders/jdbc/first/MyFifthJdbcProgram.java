package com.jspiders.jdbc.first;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyFifthJdbcProgram {
	
	public static void main(String[] args) throws IOException
	{
		
		
		try {
			Driver driverref = new Driver();
			
			DriverManager.registerDriver(driverref);
			
			File file = new File("C:\\J2eePrograms\\EclipseProgram\\Properties\\MyProp.properties");
			FileReader reader = new FileReader(file);
			
			Properties prop = new Properties();
			prop.load(reader);
			
			String dburl = prop.getProperty("url");
			Connection CON = DriverManager.getConnection(dburl, prop);
			
			String query = " select * from studentsinfo where regno = ? ";
			PreparedStatement pstmt = CON.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next())
			{
				
				System.out.println("regnumber = "+res.getInt("regno"));
				System.out.println("First name = "+res.getString("firstname"));
				System.out.println("midle name = "+res.getString("midlename"));
				System.out.println("Last name = " + res.getString("lastname"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
