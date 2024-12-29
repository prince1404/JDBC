package com;

import java.sql.*;

public class Close {
	public static void main(String[] args) {
		Connection c =null;
		
		try {
			
			//1.lord or register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Establish Connection
			 c =DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root","Maa@1404");
			
			//3. create Statement
			Statement s= c.createStatement();
			
			//4.executeQuery
			s.executeUpdate("update movie set hero='ak',collection=340 where id=6");
			
			
			System.out.println("close data");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			
			try {
				
			
				if (c !=null) {
					c.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
}
