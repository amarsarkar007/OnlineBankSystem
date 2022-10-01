package com.bank.main;

import java.util.List;
import java.util.Scanner;

import com.bank.beans.Account;
import com.bank.beans.AccountDTO;
import com.bank.beans.Customer;
import com.bank.beans.Transaction;
import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;
import com.bank.exceptions.AccountException;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CustomerDao dao = new CustomerDaoImpl();

		System.out.println("1.Login as admin");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("Enter admin Username : ");
			String username = sc.next();
			System.out.println("Enter admin password : ");
			int password = sc.nextInt();
			
			String login = dao.adminLogin(username, password);
			
			if(login.contains("Login Successfully...")) {
				
				System.out.println("1. Register customer"
						+ "\n2. Register new account"
						+ "\n3. Remove account by account number"
						+ "\n4. View account details by account number"
						+ "\n5. View all the account details"
						+ "\n6. Transfer money from one account to another"
						+ "\n7. Checking transaction history");
				
				int choice2 = sc.nextInt();
				
				switch(choice2) {
				case 1:
					
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
						
						String result = dao.RegisterCustomer2(customer);
						
						System.out.println(result);
						break;
				
				case 2:
					System.out.println("Enter customer id : ");
					int cid = sc.nextInt();
					
					System.out.println("Enter opening balance : ");
					int balance = sc.nextInt();
					
					
					String result2 = dao.createAccountForCustomer(cid, balance);
					
					System.out.println(result2);
					break;
					
				case 3:
					System.out.println("Enter Account no. to remove : ");
					int acno = sc.nextInt();
										
					String result3 = dao.RemoveAccountByAcno(acno);
					System.out.println(result3);
					break;
					
				case 4:
					System.out.println("Enter account no. : ");
					int accno = sc.nextInt();
					
					
					try {
						AccountDTO dto = dao.AccountDetailsByAccountNo(accno);
						
						System.out.println(dto);
					} catch (AccountException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
					break;
					
				case 5:
					try {
						List<Account> accounts = dao.AllAccountDetails();
						
						accounts.forEach(a -> System.out.println(a));
						
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
					
				case 6:
					System.out.println("Enter your account no. : ");
					int acc1 = sc.nextInt();
					
					System.out.println("Enter recipient's account no. : ");
					int acc2 = sc.nextInt();
					
					System.out.println("Enter amount : ");
					int amount = sc.nextInt();
					
					
					try {
						String result6 = dao.TransferMoney(acc1, acc2, amount);
						
						System.out.println(result6);
					} catch (AccountException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
					
				case 7:
					System.out.println("Enter Account no. : ");
					
					int ac2no = sc.nextInt();
					
					
					try {
						List<Transaction> transactions = dao.TransactionHistory(ac2no);
						
						transactions.forEach(t -> System.out.println(t));
						
					} catch (AccountException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				default:
					System.out.println("Wrong input...");
					break;
					
				}
				
			}
			break;
			
			default:
				System.out.println("Wrong input...");
		}
		
		
	}

}
