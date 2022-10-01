package com.bank.usecases;

import java.util.Scanner;

import com.bank.dao.CustomerDao;
import com.bank.dao.CustomerDaoImpl;

public class RemoveAccountByAcnoUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account no. to remove : ");
		int acno = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		String result = dao.RemoveAccountByAcno(acno);
		System.out.println(result);
	}

}
