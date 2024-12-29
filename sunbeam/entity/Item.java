package com.sunbeam.entity;

import java.util.Scanner;

public class Item {
	int id;
    String name;
    String Type;
    String Category;
    String Description;

    public Item(int id,String name, String type, String category, String description) {
    	this.id=id;
        this.name = name;
        Type = type;
        Category = category;
        Description = description;
    }
    
    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void acceptpizza_item(Scanner sc) {
        System.out.println("Enter Details");
        sc.nextLine();
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter type");
        Type = sc.nextLine();
        System.out.println("Enter category");
        Category = sc.nextLine();
        System.out.println("Enter description");
        Description = sc.nextLine();

    }

    @Override
    public String toString() {
        return "id="+id + ", name=" + name + ", Type=" + Type + ", Category=" + Category;
    }

}
