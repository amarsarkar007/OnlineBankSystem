package com.bank.usecases;

import java.util.List;
import java.util.Scanner;

import com.bank.beans.Transaction;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.exceptions.AccountException;

public class TransactionHistoryUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account no. : ");
		
		int acno = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			List<Transaction> transactions = dao.TransactionHistory(acno);
			
			transactions.forEach(t -> System.out.println(t));
			
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}

}
