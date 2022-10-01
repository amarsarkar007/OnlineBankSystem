package com.bank.usecases;

import java.util.Scanner;

import com.bank.beans.Customer;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;

public class RegisterCustomerUsecase2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer name : ");
		String name = sc.next();
		System.out.println("Enter customer mobile no. : ");
		String mobile = sc.next();
		System.out.println("Enter city : ");
		String city = sc.next();
		System.out.println("Enter date of birth : ");
		String dob = sc.next();
		
		Customer customer = new Customer();
		
		customer.setCname(name);
		customer.setMobile(mobile);
		customer.setCity(city);
		customer.setDob(dob);

		CustomerDao dao = new CustomerDaoImpl();
		
		String result = dao.RegisterCustomer2(customer);
		
		System.out.println(result);
		
	}

}
