import java.util.Scanner;

import java.sql.*;

public class Update {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enter id ");
		int id =s.nextInt();
		
		System.out.println("Enter collection ");
		double collection =s.nextDouble();
		
		System.out.println("Enter rating ");
		double rating =s.nextDouble();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Maa@1404");
			
			PreparedStatement ps= c.prepareStatement("update movie set collection =?, rating=? where id=?");
			ps.setDouble(1, collection);
			ps.setDouble(2, rating);
			ps.setInt(1, id);
			
			
			ps.executeUpdate();
			
			System.out.println("Data updated");
			
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
	}
}
