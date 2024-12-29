package com;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class FetchAll2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
			
			//select * from movie
			Statement s=c.createStatement();
			
			ResultSet rs=s.executeQuery("select * from movie");
			
			
			while(rs.next()) {
				System.out.println("id= "+ rs.getInt("id"));
				System.out.println("name =" +rs.getString("name"));
				System.out.println("hero = " +rs.getString("hero"));
				System.out.println("heroine = " +rs.getString("heroine"));
				System.out.println("mname = " + rs.getString("mname"));
				System.out.println("collection = " +rs.getDouble("collection"));
				System.out.println("rate = " +rs.getDouble("rate"));
				System.out.println("------------------------------------------------- ");
				
			}
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
