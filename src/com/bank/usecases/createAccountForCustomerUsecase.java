package com.bank.usecases;

import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;

public class createAccountForCustomerUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter customer id : ");
		int cid = sc.nextInt();
		
		System.out.println("Enter opening balance : ");
		int balance = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		String result = dao.createAccountForCustomer(cid, balance);
		
		System.out.println(result);
	}

}
