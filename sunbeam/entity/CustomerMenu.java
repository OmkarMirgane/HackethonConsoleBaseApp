package com.sunbeam.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.ItemDao;
import com.sunbeam.dao.LoginDao;

public class CustomerMenu {
    /*
     * 1. Show Veg Items
     * 2. Show Non-Veg Items
     * 3. Show available sizes (for given Item id)
     * 4. Add to cart (for given price id)
     * 5. Show Cart (Pizzas with Size & Price Details)
     * 6. Place Order (Save Order in Database for current customer)
     * 7. Sign Out
     */
    public static int menu() {
    	Scanner sc = new Scanner(System.in);
        int ch;
        System.out.println("Enter Your Choice");
        System.out.println("Enter 1 To Show Veg Item");
        System.out.println("Enter 2 To Show Non-Veg Items");
        System.out.println("Enter 3 To Show available sizes (for given Item id)");
        System.out.println("Enter 4 To Add to cart(for given price id)");
        System.out.println("Enter 5 To Show Cart (Pizzas with Size & Price Details)");
        System.out.println("Enter 6 To Place Order (Save Order in Database for current customer)");
        System.out.println("Enter 7 To Sign Out");

        ch = sc.nextInt();
        return ch;
    }

    public void customerMenu() {
    	List<Integer> itemPriceId=new ArrayList<Integer>();
    	Scanner sc=new Scanner(System.in);
        int ch;
        while ((ch = menu()) != 7) {
            switch (ch) {
                case 1: {
                    // Show Veg Items
                	try {
						ItemDao id=new ItemDao();
						List<Item> vegList=id.getVegItem();
						vegList.forEach(e->System.out.println(e));
						System.out.println("Displayed Successfully");
					} catch (SQLException e) {
						e.printStackTrace();
					}
                    break;
                }
                case 2: {
                    // . Show Non-Veg Items
                	try {
						ItemDao id=new ItemDao();
						List<Item> nonvegList=id.getNonVegItem();
						nonvegList.forEach(e->System.out.println(e));
						System.out.println("Displayed Successfully");
					} catch (SQLException e) {
						e.printStackTrace();
					}
                    break;
                }
                case 3: {
                    // . Show available sizes (for given Item id)
                	try {
						ItemDao id=new ItemDao();
						List<String> sizesList=id.getAllSizes();
						sizesList.forEach(e->System.out.println(e));
						System.out.println("Displayed Successfully");
					} catch (SQLException e) {
						e.printStackTrace();
					}
                    break;
                }
                case 4: {
                    // Add to cart (for given price id)
                	System.out.println("Enter the Price Id ");
                    int id=sc.nextInt();
                    itemPriceId.add(id);
                    System.out.println("Added Into the Cart Successfully");
                    break;
                }
                case 5: {
                    // Show Cart (Pizzas with Size & Price Details)
                	ItemDao id;
					try {
						id = new ItemDao();
						id.showCart(itemPriceId);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   
                    break;
                }
                case 6: {
                    // . Place Order (Save Order in Database for current customer)
                	try {
						LoginDao ld=new LoginDao();
						String email=ld.FetchCustomer(sc);
						ItemDao id=new ItemDao();
						id.customerId(email);						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;
                }
                case 7: {
                    // Sign out
                	System.out.println("Thank You!!!");
                    break;
                }

            }
        }

    }
}

