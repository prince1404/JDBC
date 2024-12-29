package com;

import java.sql.*;
public class Delete {
	public static void main(String[] args) {
		
		
		
		try {
			//1.load or register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish Connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db", "root","Maa@1404");
			
			//3. create Statement
			Statement s= c.createStatement();
			
			//4.executeQuery
			s.executeUpdate("delete from movie where id =2");
			
			
			System.out.println("deleted data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
