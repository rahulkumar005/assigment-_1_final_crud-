package com.greycampus;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Choose the option to perform the type of operation");
		System.out.println("1-INSERTION");
		System.out.println("2-UPDATE");
		System.out.println("3_DELETE");
		System.out.println("4-SELECT ALL");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			CreateCustomerDetails Details = new CreateCustomerDetails();
			System.out.println("enter cid:");
			int cid = scanner.nextInt();
			System.out.println("enter the firstname:");
			String firstname = scanner.next();
			System.out.println("enter lastname:");
			String lastname = scanner.next();
			System.out.println("enter street:");
			String street = scanner.next();
			System.out.println("enter city:");
			String city = scanner.next();
			System.out.println("enter State:");
			String state = scanner.next();
			System.out.println("enter Zipcode:");
			int zipcode = scanner.nextInt();
			System.out.println("enter product name:");
			String productname = scanner.next();
			System.out.println("enter created by:");
			String createdby = scanner.next(); 	
			Details.setCid(cid);
			Details.setFirstname(firstname);
			Details.setLastname(lastname);
			Details.setStreet(street);
			Details.setCity(city);
			Details.setState(state);
			Details.setZipcode(zipcode);
			Details.setProductname(productname);
			Details.setCreatedby(createdby);

			InsertOperation insertOperation = new InsertOperation();
			insertOperation.insert(Details);
			break;

		case 2:
			System.out.println("enter the update firstname:");
			String firstname1 = scanner.next();
			System.out.println("enter the update lastname:");
			String lastname1 = scanner.next();
			System.out.println("enter the update city:");
			String city1 = scanner.next();
			System.out.println("enter updated by:");
			String updatedby = scanner.next();
			System.out.println("enter the cid:");
			int cid1 = scanner.nextInt();

			UpdateCustomer updateCustomer = new UpdateCustomer();
			updateCustomer.setCid(cid1);
			updateCustomer.setFirstname(firstname1);
			updateCustomer.setLastname(lastname1);
			updateCustomer.setCity(city1);
			updateCustomer.setUpdatedby(updatedby);

			Updatedata updatedata = new Updatedata();
			updatedata.update(updateCustomer);
			break;

		case 3:
			System.out.println("enter the cid :");
			int cid2 = scanner.nextInt();
			DeleteCustomer deleteCustomer = new DeleteCustomer();
			deleteCustomer.setCid(cid2);
			Deletedata deletedata = new Deletedata();
			deletedata.delete(deleteCustomer);
			break;

		case 4:SelectData selectData = new SelectData();
		       selectData.Select();
		       break;
		}
		scanner.close();

	}

}
