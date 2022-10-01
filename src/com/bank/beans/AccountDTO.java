package com.bank.beans;

public class AccountDTO {
	
	private int acno;
	private int cid;
	private String cname;
	private int balance;
	private String mobile;
	private String city;
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(int acno, int cid, String cname, int balance, String mobile, String city) {
		super();
		this.acno = acno;
		this.cid = cid;
		this.cname = cname;
		this.balance = balance;
		this.mobile = mobile;
		this.city = city;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AccountDTO [acno=" + acno + ", cid=" + cid + ", cname=" + cname + ", balance=" + balance + ", mobile="
				+ mobile + ", city=" + city + "]";
	}
	
	
}
