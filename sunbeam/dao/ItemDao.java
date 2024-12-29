package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.entity.Item;
import com.sunbeam.utils.DbUtil;

public class ItemDao implements AutoCloseable{
    // 1. Show Veg Items
    // 2. Show Non-Veg Items
	
    private Connection connection;
	

	public ItemDao() throws SQLException {
		connection=DbUtil.getConnection();
	}

    public List<Item> getVegItem() throws SQLException {

        List<Item> itemList = new ArrayList<Item>();
        String sql = "Select id,Name,Type,Category from pizza_items where Type='Veg'";
       
       PreparedStatement selectstmt = connection.prepareStatement(sql) ;
            ResultSet rs = selectstmt.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setType(rs.getString(3));
                item.setCategory(rs.getString(4));
                itemList.add(item);

            }
        return itemList;

    }

    public List<Item> getNonVegItem() throws SQLException{

        List<Item> itemList = new ArrayList<Item>();
        String sql = "Select id,Name,Type,Category  from pizza_items where Type='NonVeg'";
        PreparedStatement selectstmt = connection.prepareStatement(sql);
            ResultSet rs = selectstmt.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setType(rs.getString(3));
                item.setCategory(rs.getString(4));
                itemList.add(item);

            }
        return itemList;

    }
    
    public List<String> getAllSizes() throws SQLException{
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the Item id");
    	int id=sc.nextInt();
    	List<String> sizes=new ArrayList<String>();
    	String sql="select sizes from pizza_pricing where itemid=?";
    	PreparedStatement selectstmt=connection.prepareStatement(sql);
    	selectstmt.setInt(1,id);
    	ResultSet rs=selectstmt.executeQuery();
    	while(rs.next()) {
    		sizes.add(rs.getString(1));
    	}
		return sizes;
    	
    }
    
    public void showCart(List<Integer> itemList) throws SQLException {
    	int total_price=0;
    	for(int e:itemList) {
    		String sql="select SIZES,Price from pizza_pricing where ID=?";
    		PreparedStatement st=connection.prepareStatement(sql);
    		st.setInt(1,e);
    		ResultSet rs=st.executeQuery();
    		while(rs.next()) {
    			total_price+=rs.getInt(2);
    			System.out.println("Size ="+rs.getString(1)+",Price="+rs.getInt(2));    			
    		}
    	}
    	System.out.println("Total Cost of the Cart = "+total_price);
    }
    
    public void customerId(String email) throws SQLException {
    	int id;
    	String sql="select id from pizza_customers where email=?";
    	PreparedStatement st=connection.prepareStatement(sql);
    	st.setString(1, email);    	
    	ResultSet rs=st.executeQuery();
    	while(rs.next()) {
    		id=rs.getInt(1);    	 	
    	System.out.println(id);
    	String s="insert into pizza_orders(customerid,OrderTime,Status) values (?,now(),'Pending')";
    	PreparedStatement sta=connection.prepareStatement(s);
    	sta.setInt(1, id);
    	sta.execute();
    	}
    
    }

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(connection!=null) {
			connection.close();
		}
	}
}
