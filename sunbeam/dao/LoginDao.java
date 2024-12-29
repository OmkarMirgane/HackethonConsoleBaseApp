package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.entity.Customer;
import com.sunbeam.utils.DbUtil;

public class LoginDao implements AutoCloseable{
	
    private Connection connection;
	

	public LoginDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public void addCustomer() throws SQLException {
		Customer s=new Customer();
		Scanner sc=new Scanner(System.in);
		s.accept(sc);
		String sql="insert into pizza_customers(name,email,password,mobile,address) values (?,?,?,?,?)";
		PreparedStatement insertStmt=connection.prepareStatement(sql);
		insertStmt.setString(1,s.getName());
		insertStmt.setString(2,s.getEmail());
		insertStmt.setString(3,s.getPassword());
		insertStmt.setString(4,s.getMobile());
		insertStmt.setString(5,s.getAddress());
		insertStmt.executeUpdate();
		System.out.println("Added Customer Successfully");
	}
	
	
	public String FetchCustomer(Scanner sc) throws SQLException {
		String email, password;
        System.out.print("Enter email: ");
        email = sc.next();
        System.out.print("Enter password: ");
        password = sc.next();
        String sql="select email from pizza_customers where email=? and password=?";                
        PreparedStatement display=connection.prepareStatement(sql);
        display.setString(1, email);
        display.setString(2, password);
        ResultSet rs=display.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        
		return null;
	}


	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(connection!=null) {
			connection.close();
		}
	}

}