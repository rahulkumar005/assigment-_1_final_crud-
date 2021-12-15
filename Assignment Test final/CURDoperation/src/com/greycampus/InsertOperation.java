package com.greycampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {

	public void insert(CreateCustomerDetails customer) {

	

		String query = "INSERT INTO CUSTOMER_DETAILS(CID,FIRSTNAME,LASTNAME,STREET,CITY,STATE,ZIPCODE,PRODUCT_NAME,CREATED_ON,CREATED_BY) VALUES(?,?,?,?,?,?,?,?,?,?)";
		CreateConnection createConnection = new CreateConnection();
		Connection con = createConnection.getconnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = con.prepareStatement(query);
			prepareStatement.setInt(1, customer.getCid());
			prepareStatement.setString(2, customer.getFirstname());
			prepareStatement.setString(3, customer.getLastname());
			prepareStatement.setString(4, customer.getStreet());
			prepareStatement.setString(5, customer.getCity());
			prepareStatement.setString(6, customer.getState());
			prepareStatement.setInt(7, customer.getZipcode());
			prepareStatement.setString(8, customer.getProductname());
			prepareStatement.setDate(9,new java.sql.Date(System.currentTimeMillis()));
			prepareStatement.setString(10, customer.getCreatedby());
			int count = prepareStatement.executeUpdate();
			if (count != 0) {
				System.out.println(count + "customer added");
			} else {
				System.out.println("customer not added");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

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
