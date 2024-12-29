package com.sunbeam.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.dao.LoginDao;
import com.sunbeam.entity.Admin_Menu;
import com.sunbeam.entity.CustomerMenu;

public class Test {
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int ch;
        System.out.println("Enter Your Choice");
        System.out.println("Enter 1 To SignUp");
        System.out.println("Enter 2 To SignIn");
        System.out.println("Enter 3 To Exit");
        ch = sc.nextInt();
        return ch;
    }

    public static void main(String[] args) {
        int ch;
        while ((ch = menu()) != 3) {
            switch (ch) {
                case 1: {
                	try {
            			LoginDao ld=new LoginDao();
            			ld.addCustomer();
            		} catch (SQLException e) {
            			e.printStackTrace();
            		}
                    break;
                }
                case 2: {
                	Scanner sc=new Scanner(System.in);
                	    try {
							LoginDao ld=new LoginDao();
							String e=ld.FetchCustomer(sc);
							if(e.equals("admin@sunbeaminfo.com")) {
								//Admin Menu
								Admin_Menu am=new Admin_Menu();
								am.adminMenu();
							}
							else if(e==null) {
								System.out.println("No Customer Found Please Sign up");
							}
							else {
								//Customer Menu
								CustomerMenu cm=new CustomerMenu();
								cm.customerMenu();
							}
						} catch (SQLException e) {
                	    e.printStackTrace();
						}       	
                    break;
                }
                case 3: {
                    System.out.println("Thank You!!!");
                    
                    break;
                }
            }
        }
    }
}
