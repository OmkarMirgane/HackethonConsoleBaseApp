package com.sunbeam.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entity.Orders;
import com.sunbeam.utils.DbUtil;

public class OrdersDao {
    // Insert given order along with order details.
    // Fetch all orders in descending order of time.
    // Fetch order of given id.

    // 1. Show all orders
    // 2. Show order details (for given order id show Pizza & Customer details)
	
    private Connection connection;
	

	public OrdersDao() throws SQLException {
		connection=DbUtil.getConnection();
	}

    public void insertOrder() throws SQLException {
        String query = "INSERT INTO orders (order_id, customer_id, order_time) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(query);

    }

    public List<Orders> getAllOrder() throws SQLException {

        List<Orders> orderList = new ArrayList<Orders>();
        String sql = "select * from pizza_orders";
        PreparedStatement selectstmt = connection.prepareStatement(sql);
        ResultSet rs = selectstmt.executeQuery();
        while (rs.next()) {
            Orders order = new Orders();

            order.setId(rs.getInt(1));
            order.setCustomerid(rs.getInt(2));
            order.setOrderTime(rs.getString(3));
            order.setStatus(rs.getString(4));
            orderList.add(order);

        }

        return orderList;

    }

    // 2. Show order details (for given order id show Pizza & Customer details)

    public void getAllOrderforparticularid(int id) throws SQLException {

        List<Orders> orderList = new ArrayList<Orders>();
        String sql = "select pizza_orders.ID,pizza_orders.CustomerId, pizza_customers.name,pizza_customers.Mobile from pizza_orders join pizza_customers on pizza_customers.ID=pizza_orders.CustomerId where pizza_orders.ID=?;";
        PreparedStatement selectstmt = connection.prepareStatement(sql);
        selectstmt.setInt(1, id);

        ResultSet rs = selectstmt.executeQuery();
        while (rs.next()) {

            System.out.println("Order id= "+rs.getInt(1) + " ,Customer Id=" + rs.getInt(2) + ",Customer Name =" + rs.getString(3) + ",Mobile Number =" + rs.getString(4));

        }

    }
}
