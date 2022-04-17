package com.Assignment;
import java.sql.*;
public class Jdbc {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		String qry = "insert into students values(?,?,?)";

		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment3?user=root & password=karanthakur");
			System.out.println("connection is established");
			
			psmt = con.prepareStatement(qry);
			psmt.setInt(1, 9);
			psmt.setString( 2, "Hema");
			psmt.setDouble( 3, 74.00);
			psmt.executeUpdate();
			
			
			psmt.setInt(1, 8);
			psmt.setString( 2, "Himanshu");
			psmt.setDouble( 3, 72.00);
			psmt.executeUpdate();
		}
		catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			if(psmt!=null) {
				psmt.close();
			}
			if(con!=null) {
				try {
					con.close();
				}
				
				catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		System.out.println("costly resourses closed");
			
			
			
		}

	
		
	}
		
		
		



