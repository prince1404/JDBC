package com;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class FetchAllName {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the name");
		String name=s.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
			PreparedStatement ps= c.prepareStatement("select name,hero,mname,collection from movie where name = ? ");
			
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("name =" +rs.getString("name"));
				System.out.println("hero = " +rs.getString("hero"));
				System.out.println("mname = " + rs.getString("mname"));
				System.out.println("collection = " +rs.getDouble("collection"));
				
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
