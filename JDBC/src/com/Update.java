package com;

import java.sql.*;

public class Update {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root","Maa@1404");
			
			//3. create Statement
			Statement s= c.createStatement();
			
			//4.executeQuery
			s.executeUpdate("update movie set hero='ak',collection=300 where id=1");
			
			
			System.out.println("update data");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
