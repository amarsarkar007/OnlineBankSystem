package com.bank.usecases;

import java.util.Scanner;

import com.bank.beans.AccountDTO;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.exceptions.AccountException;

public class AccountDetailsByAccountNoUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account no. : ");
		int acno = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			AccountDTO dto = dao.AccountDetailsByAccountNo(acno);
			
			System.out.println(dto);
		} catch (AccountException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
	}

}
