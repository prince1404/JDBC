package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete2 {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enetr id");
		int id=s.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:musql://localhost:3306/movie_db","root","Maa@1404");
			
			PreparedStatement ps =c.prepareStatement("delete from movie where id =?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("deleted data");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
