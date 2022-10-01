package com.bank.dao;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountDTO;
import com.bank.beans.Customer;
import com.bank.beans.Transaction;
import com.bank.exceptions.AccountException;

public interface CustomerDao {
	
	public String adminLogin(String username, int password);
	
	public String RegisterCustomer(String name, String mobile, String city, String dob);
	
	public String RegisterCustomer2(Customer customer);
	
	public String createAccountForCustomer(int cid, int balance);
	
	public String RemoveAccountByAcno(int acno);
	
	public AccountDTO AccountDetailsByAccountNo(int acno)throws AccountException;
	
	public List<Account> AllAccountDetails()throws AccountException;
	
	public String TransferMoney(int accountNo1, int accountNo2, int amount)throws AccountException;
	
	public List<Transaction> TransactionHistory(int acno)throws AccountException;


}
