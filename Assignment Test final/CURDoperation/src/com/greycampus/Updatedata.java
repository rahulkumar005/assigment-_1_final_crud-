package com.greycampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updatedata {
	
	public void update(UpdateCustomer customer) {
		String query="update CUSTOMER_DETAILS SET FIRSTNAME=?,LASTNAME=?,CITY=?,UPDATED_ON=?,UPDATED_BY=? where CID=?";
		
		PreparedStatement prepareStatement=null;
		CreateConnection createConnection = new CreateConnection();
		Connection con=createConnection.getconnection();
		
	
		try {
			prepareStatement= con.prepareStatement(query);
			prepareStatement.setString(1,customer.getFirstname());
			prepareStatement.setString(2,customer.getLastname());
			prepareStatement.setString(3,customer.getCity());
			prepareStatement.setDate(4,new java.sql.Date(System.currentTimeMillis()));
			prepareStatement.setString(5,customer.getUpdatedby());
			prepareStatement.setInt(6,customer.getCid());
			int count = prepareStatement.executeUpdate();
			if(count!=0) {
			System.out.println(count+"customer data updated");
			}else {
				System.out.println("customer data not updated");
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
