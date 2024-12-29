package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Data1 {
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Start collection ");
		double start= s.nextDouble();
		
		System.out.println("Enter ending collection");
		double end =s.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
			PreparedStatement ps =c.prepareStatement( "select * from movie where collection between ? and ?");
				ps.setDouble(1, end);
				ps.setDouble(2, end);
				
				
				ResultSet rs=ps.executeQuery();
				
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
