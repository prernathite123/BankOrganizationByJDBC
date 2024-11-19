package com.Application;

import java.util.Scanner;

import com.Entity.Bank;

public class App {

	public static void main(String[] args) {
		Bank b=new Bank();
		Scanner sc=new Scanner (System.in);
		boolean start=true;
		while (start) {
			System.out.println("1] Adding a new customer");
			System.out.println("2] Updating a customer details");
			System.out.println("3] deleteing customer");
			System.out.println("4] Getting all the data of customer");
			System.out.println("5] Getting a single data of  customer");
			System.out.println("6] withdraw  amount");
			System.out.println("7] deposite amount");
			System.out.println("8] exit");
			
			int choice =sc.nextInt();
			
			switch (choice) {
			case 1: b.insert();
			break;
			
			case 2: b.update();
			break;
			
			case 3: b.delete();
			break;
			
			case 4: b.getAllData();
			break;
			
			case 5: b.getSingleData();
			break;
			
			case 6: b.withdraw();
			break;
			
			case 7: b.deposite();
			break;
			
			case 8:start=false;
		          System.out.println("THANK YOU FOR VISITING");
			break;
			
			
			
			
			
		}
		
		}	
		
	}
}
