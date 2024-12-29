package com;

import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args) {
		Scanner s=new Scanner (System.in);
		
		Connection c=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
          c= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
         System.out.println("Enter count");
         int count=s.nextInt();
         
         
         
         
			PreparedStatement ps= c.prepareStatement("insert into movie value (?,?,?,?,?,?,?)");
			
			for(int i=1;i<=count;i++) {
				System.out.println("Enter id ");
				int id =s.nextInt();
				
				System.out.println("Enter movie name ");
				String name=s.next();
				
				System.out.println("Enter hero name ");
				String heroname=s.next();
				
				System.out.println("Enter heroine name ");
				String heroinename=s.next();
				
				System.out.println("Enter m name");
				String mname=s.next();
				
				System.out.println("Enter collection ");
				double collection =s.nextDouble();
				
				System.out.println("Enter rating ");
				double rate =s.nextDouble();
				
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, heroname);
				ps.setString(4, heroinename);
				ps.setString(5, mname);
				ps.setDouble(7, rate);
				ps.setDouble(6, collection);
				
				ps.addBatch();
				
				
				
			}
			
			ps.executeBatch();
			System.out.println("Data inserted");
			
			ps.clearBatch();
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
