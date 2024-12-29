package com;

import java.sql.*;
import java.sql.DriverManager;

public class insert {
	public static void main(String[] args) {
		try {
			//1. load or register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Establish Connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root","Maa@1404");
		
			//3. create Statement
			Statement s= c.createStatement();
			
			//4.executeQuery
			s.executeUpdate("insert into movie values (3, 'bhool bhuliya', 'akshay', 'vidya', 'rsk', 300, 4)");
			
			System.out.println("data inserted");
		} 
		catch ( ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
		}
	}
}
