package com.greycampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletedata {
	public void delete(DeleteCustomer del) {
		String query="delete from CUSTOMER_DETAILS where CID=?";
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.getconnection();
		PreparedStatement prepareStatement = null;
		try {
		    prepareStatement = con.prepareStatement(query);
			prepareStatement.setInt(1,del.getCid());
			int count = prepareStatement.executeUpdate();
			if(count!=0) {
			System.out.println("data deleted");
			}else {
				System.out.println("data not deleted");
			}
			
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
