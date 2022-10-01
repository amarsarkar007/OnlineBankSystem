package com.bank.usecases;

import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;

public class RegisterCustomerUsecase {

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

		CustomerDao dao = new CustomerDaoImpl();
		
		String result = dao.RegisterCustomer(name, mobile, city, dob);
		
		System.out.println(result);
		
	}

}
