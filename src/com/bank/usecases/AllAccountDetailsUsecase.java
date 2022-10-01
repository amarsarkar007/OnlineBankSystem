package com.bank.usecases;

import java.util.List;

import com.bank.beans.Account;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.exceptions.AccountException;

public class AllAccountDetailsUsecase {

	public static void main(String[] args) {

		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			List<Account> accounts = dao.AllAccountDetails();
			
			accounts.forEach(a -> System.out.println(a));
			
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
