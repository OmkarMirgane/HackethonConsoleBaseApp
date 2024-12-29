package com.sunbeam.entity;

import java.util.Scanner;

public class Customer {
	private String name;
	private String password;
	private String mobile;
	private String address;
	private String email;
	
	public void accept(Scanner sc) {
		System.out.println("Enter the Name of the Customer");
		name=sc.next();
		System.out.println("Enter the Email of the Customer");
		email=sc.next();
		System.out.println("Enter the Password ");
		password=sc.next();
		System.out.println("Enter the Address of the Customer");
		address=sc.next();
		System.out.println("Enter the Mobile Number of the Customer");
		mobile=sc.next();
	}
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", mobile=" + mobile + ", address=" + address
				+ ", email=" + email + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
