package com.bank.beans;

public class Transaction {
	
	private int acno;
	private int cid;
	private String tranferType;
	private int amount;
	private int transToAcno;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(int acno, int cid, String tranferType, int amount, int transToAcno) {
		super();
		this.acno = acno;
		this.cid = cid;
		this.tranferType = tranferType;
		this.amount = amount;
		this.transToAcno = transToAcno;
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

	public String getTranferType() {
		return tranferType;
	}

	public void setTranferType(String tranferType) {
		this.tranferType = tranferType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTransToAcno() {
		return transToAcno;
	}

	public void setTransToAcno(int transToAcno) {
		this.transToAcno = transToAcno;
	}

	@Override
	public String toString() {
		return "Transaction [acno=" + acno + ", cid=" + cid + ", tranferType=" + tranferType + ", amount=" + amount
				+ ", transToAcno=" + transToAcno + "]";
	}
	
	

}
