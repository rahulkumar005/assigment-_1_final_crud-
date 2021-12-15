package com.greycampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectData {
	public void Select() {
		String query="select * from CUSTOMER_DETAILS";
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.getconnection();
		PreparedStatement prepareStatement = null;
		try {
			 prepareStatement= con.prepareStatement(query);
			 ResultSet result = prepareStatement.executeQuery();
			 while(result.next()) {
				 for(int i=1;i<=12;i++) {
				 System.out.print(result.getString(i)+":");
				 }
				 System.out.println();		 
			 }
			 result.close();
			 System.out.println("ALL DATA RETRIEVED");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
