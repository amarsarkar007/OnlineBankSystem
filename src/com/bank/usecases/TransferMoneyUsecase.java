package com.bank.usecases;

import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.exceptions.AccountException;

public class TransferMoneyUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your account no. : ");
		int acc1 = sc.nextInt();
		
		System.out.println("Enter recipient's account no. : ");
		int acc2 = sc.nextInt();
		
		System.out.println("Enter amount : ");
		int amount = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			String result = dao.TransferMoney(acc1, acc2, amount);
			
			System.out.println(result);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
