package com.sunbeam.entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.OrdersDao;

public class Admin_Menu {
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int ch;
        System.out.println("Enter Your Choice");
        System.out.println("Enter 1 To Show All orders");
        System.out.println("Enter 2 To Show order details (for given order id show Pizza & Customer details)");
        System.out.println("Enter 3 3. Sign Out");

        ch = sc.nextInt();
        return ch;
    }

    public void adminMenu(){
        int ch;
        while ((ch = menu()) != 3) {
            switch (ch) {
                case 1: {
                    // Show all orders
                	try {
						OrdersDao od=new OrdersDao();						
						List<Orders> ordersList=od.getAllOrder();
						ordersList.forEach(e->System.out.println(e));
						System.out.println("Displayed Successfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
                case 2: {
                	Scanner sc=new Scanner(System.in);
                    // . Show order details (for given order id show Pizza & Customer details)
                	System.out.println("Enter the id ");
                	int id=sc.nextInt();
                	try {
						OrdersDao od=new OrdersDao();						
						od.getAllOrderforparticularid(id);
						//ordersList.forEach(e->System.out.println(e));
						System.out.println("Displayed Successfully");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
                case 3: {
                    // . sign out
                	System.out.println("Thank You!!!!");
                    return;

                }

            }
        }
    }
}
