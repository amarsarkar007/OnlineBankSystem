package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountDTO;
import com.bank.beans.Customer;
import com.bank.beans.Transaction;
import com.bank.exceptions.AccountException;
import com.bank.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String RegisterCustomer(String name, String mobile, String city, String dob) {
		String msg = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into customer(cname,mobile,city,dob) values(?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, city);
			ps.setString(4, dob);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Customer registered successfully...";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String RegisterCustomer2(Customer customer) {
String msg = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into customer(cname,mobile,city,dob) values(?,?,?,?)");
			
			ps.setString(1, customer.getCname());
			ps.setString(2, customer.getMobile());
			ps.setString(3, customer.getCity());
			ps.setString(4, customer.getDob());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Customer registered successfully...";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
		
	}

	@Override
	public String createAccountForCustomer(int cid, int balance) {
		String msg = "Account not created..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into account(cid,balance,acnt_create_date) values(?,?,CURDATE())");
			
			ps.setInt(1, cid);
			ps.setInt(2, balance);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Account created successfully....";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String RemoveAccountByAcno(int acno) {
		String msg = "No account found...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from account where acno = ?");
			
			ps.setInt(1, acno);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Account removed successfully...";
			}
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public AccountDTO AccountDetailsByAccountNo(int acno)throws AccountException {
		AccountDTO dto = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select c.cid, c.cname, c.mobile, c.city, a.acno, a.balance from customer c inner Join account a ON c.cid = a.cid AND a.acno = ?;");
			
			ps.setInt(1, acno);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String mobile = rs.getString("mobile");
				String city = rs.getString("city");
				int accno = rs.getInt("acno");
				int balance = rs.getInt("balance");
				
				dto = new AccountDTO(accno,cid,cname,balance,mobile,city);
				
			}else {
				
				throw new AccountException("Account doesn't exist...");
				
			}
		
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		return dto;
	}

	@Override
	public List<Account> AllAccountDetails() throws AccountException {
		List<Account> accounts = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from account");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int acno = rs.getInt("acno");
				int cid = rs.getInt("cid");
				int balance = rs.getInt("balance");
				String date = rs.getString("acnt_create_date");
				
				Account account = new Account(acno,cid,balance,date);
				
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		
		if(accounts.isEmpty()) {
			throw new AccountException("No account found...!");
		}
		
		
		return accounts;
	}

	@Override
	public String TransferMoney(int accountNo1, int accountNo2, int amount) throws AccountException {
		String msg = "Transaction falied...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select balance from account where acno = ?");
			
			ps.setInt(1, accountNo1);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int acc1balance = rs.getInt("balance");
				
				if(acc1balance<amount) {
					throw new AccountException("Insufficient Balance");
				}
				else {
					PreparedStatement ps2 = conn.prepareStatement("select balance from account where acno = ?");
					
					ps2.setInt(1, accountNo2);
					ResultSet rs2 = ps2.executeQuery();
					
					if(rs2.next()) {
						int acc2balance = rs2.getInt("balance");
						
						int acc1UpdateBalance = acc1balance - amount;
						int acc2UpdateBalance = acc2balance + amount;
						
						PreparedStatement ps3 = conn.prepareStatement("update account set balance = ? where acno=?");
						ps3.setInt(1, acc1UpdateBalance);
						ps3.setInt(2, accountNo1);
						
						ps3.executeUpdate();
						
						PreparedStatement ps4 = conn.prepareStatement("update account set balance = ? where acno=?");
						ps4.setInt(1, acc2UpdateBalance);
						ps4.setInt(2, accountNo2);
						
						ps4.executeUpdate();
						
						PreparedStatement ps5 = conn.prepareStatement("select c.cid from customer c inner join account a where c.cid = a.cid and a.acno=?");
						ps5.setInt(1, accountNo1);
						ResultSet rs3 = ps5.executeQuery();
						rs3.next();
						int cid = rs3.getInt("cid");
						
						PreparedStatement ps6 = conn.prepareStatement("insert into transactions values(?,?,'transfer',?,?)");
						
						ps6.setInt(1, accountNo1);
						ps6.setInt(2, cid);
						ps6.setInt(3, amount);
						ps6.setInt(4, accountNo2);
						
						int x = ps6.executeUpdate();
						
						if(x>0) {
							msg = "Transfer Successfull....";
						}
						else {
							throw new AccountException("Technical error..!!");
						}
						
					}
					else {
						throw new AccountException("Invalid account no....");
					}
					
				}
				
				
			}
			else {
				throw new AccountException("Invalid account no....");
			}
			
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Transaction> TransactionHistory(int acno) throws AccountException {
		List<Transaction> transactions = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from transactions where acno = ?");
			ps.setInt(1, acno);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accno = rs.getInt("acno");
				int cid = rs.getInt("cid");
				String transferType = rs.getString("trans_type");
				int amount = rs.getInt("amount");
				int transToAcno = rs.getInt("transfer_to_acnt");
				
				Transaction transaction = new Transaction(accno,cid,transferType,amount,transToAcno);
				
				transactions.add(transaction);
			}
			
			
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		if(transactions.isEmpty()) {
			throw new AccountException("No transaction history found...");
		}
		
		
		
		return transactions;
	}

	@Override
	public String adminLogin(String username, int password) {
		String msg = "Invalid username or password...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");
			ps.setString(1, username);
			ps.setInt(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				msg = "Login Successfully...\nWelcome "+username;
			}

			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return msg;
	}

}
