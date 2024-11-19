package com.Entity;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.Configuration.Config;

import com.Unimplemented.BankUnimpl;


public class Bank implements BankUnimpl{
 
	Scanner sc=new Scanner(System.in);
	@Override
	public void insert() {
		try {
			Connection con=Config.connecting();
			PreparedStatement ps=con.prepareStatement("insert into customer (id,name ,balance ,accountno) values(?,?,?,?);");
			
			System.out.println("Enter id");
			int i=sc.nextInt();
			
			System.out.println("Enter name");
			String n=sc.next();
			
			System.out.println("Enter balance");
			double b=sc.nextDouble();
			
			System.out.println("Enter Account no");
			long a=sc.nextLong();
			
			ps.setInt(1,i);
			ps.setString(2, n);
			ps.setDouble(3, b);
			ps.setLong(4, a);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update() {
		try {
			Connection con=Config.connecting();
	    	
	    	String query="update customer set name=? where id=?;";
	    	PreparedStatement ps =con.prepareStatement(query);
	    	System.out.println("enter the value of updated name:");
	    	String n=sc.next();
	    	System.out.println("which id you want to update");
	    	int i=sc.nextInt();
	    	
//	    	
	    	
	    	ps.setString(1, n);
	    	ps.setInt(2, i);
	    	
	    	
	    	ps.executeUpdate();
	    	ps.close();
	    	con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
         
	}
	
	@Override
	public void delete() {
		Connection con;
		try {
			con = Config.connecting();
			String query="delete from customer where id=?;";
		     PreparedStatement ps=con.prepareStatement(query);
		     System.out.println("enter which id");
		     int n=sc.nextInt();
		     
		     ps.setInt(1, n);
		     
		     ps.executeUpdate();
		 	ps.close();
		 	con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	     
	}
	
	@Override
	public void getAllData() {
		Connection con;
		try {
			con = Config.connecting();
			Statement state=con.createStatement();
			String query="select * from customer;";
			ResultSet set=state.executeQuery(query);
			
			while (set.next()) {
				System.out.println(set.getInt(1));
				System.out.println(set.getString(2)); 
				
				System.out.println(set.getDouble(3));
				System.out.println(set.getLong(4));
				
			}
			
			state.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	@Override
	public void getSingleData() {
		try {
			Connection con=Config.connecting();
	    	String query= "SELECT * FROM customer WHERE id = ?;";
	    	PreparedStatement ps=con.prepareStatement(query);
	    	System.out.println("enter the id which you want to display");
			int i=sc.nextInt();
			ps.setInt(1, i);
			ResultSet rs= ps.executeQuery();
			
			while (rs.next()) {
				 System.out.println("Employee ID: " + rs.getInt(1));
			        System.out.println("Employee Name: " + rs.getString(2));
			        System.out.println("Employee Salary: " + rs.getDouble(3));
			        System.out.println("Customer account no: "+rs.getLong(4));
				
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Override
	public void withdraw() {
		
		System.out.println("Enter id ");
		int id=sc.nextInt();
		System.out.println("Enter amt");
		double amt=sc.nextDouble();
		
		try {
			Connection con=Config.connecting();
			PreparedStatement ps=con.prepareStatement("select* from customer where id=?");
			ps.setInt(1,id);
			double b=0;
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				b=rs.getDouble(3);
			}
			b=b-amt;
			System.out.println(b);
			rs.close();
			
			PreparedStatement ps1=con.prepareStatement("update customer set balance=? where id=?;");
			ps1.setDouble(1, b);
			ps1.setInt(2, id);
			
			ps1.executeUpdate();
			ps1.close();
			con.close();
			
			
		} catch ( Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void deposite() {

		System.out.println("Enter id ");
		int id=sc.nextInt();
		System.out.println("Enter amt");
		double amt=sc.nextDouble();
		
		try {
			Connection con=Config.connecting();
			PreparedStatement ps=con.prepareStatement("select* from customer where id=?");
			ps.setInt(1,id);
			double b=0;
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				b=rs.getDouble(3);
			}
			b=b+amt;
			System.out.println(b);
			rs.close();
			
			PreparedStatement ps1=con.prepareStatement("update customer set balance=? where id=?;");
			ps1.setDouble(1, b);
			ps1.setInt(2, id);
			
			ps1.executeUpdate();
			ps1.close();
			con.close();
			
			
		} catch ( Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
