package com;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class FetchAll {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
			
			//select * from movie
			Statement s=c.createStatement();
			
			ResultSet rs=s.executeQuery("select * from movie");
			
			
			System.out.println(rs.next());
			System.out.println(rs.next());
			System.out.println(rs.next());
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
