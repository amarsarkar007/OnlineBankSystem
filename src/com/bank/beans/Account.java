package com.bank.beans;

public class Account {
	
	private int acno;
	private int cid;
	private int balance;
	private String dob;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int acno, int cid, int balance, String dob) {
		super();
		this.acno = acno;
		this.cid = cid;
		this.balance = balance;
		this.dob = dob;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Account [acno=" + acno + ", cid=" + cid + ", balance=" + balance + ", dob=" + dob + "]";
	}
	
	

}