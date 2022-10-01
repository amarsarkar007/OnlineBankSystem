package com.bank.beans;

public class Customer {
	
	private int cid;
	private String cname;
	private String mobile;
	private String city;
	private String dob;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(int cid, String cname, String mobile, String city, String dob) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.mobile = mobile;
		this.city = city;
		this.dob = dob;
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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", mobile=" + mobile + ", city=" + city + ", dob=" + dob
				+ "]";
	}
	
	

}
