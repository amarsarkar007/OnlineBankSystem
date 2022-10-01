package com.bank.usecases;

import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;

public class adminLoginUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username : ");
		String username = sc.next();
		System.out.println("Enter password : ");
		int password = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		String result = dao.adminLogin(username, password);
		
		System.out.println(result);
	}

}
