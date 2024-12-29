package com;

import java.sql.*;
public class Demo {
	public static void main(String[] args) {
		try {
			//1 st step
			//1) load or register
			//explicit
			java.sql.Driver d= new com.mysql.cj.jdbc.Driver();
			
			DriverManager.registerDriver(d);
			
			System.out.println("load or register succefully!!" );
		} 
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
