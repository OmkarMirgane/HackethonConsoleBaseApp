package com.sunbeam.entity;

public class Orders {
    int id;
    int Customerid;
    String OrderTime;
    String Status;

    public int getCustomerid() {
        return Customerid;
    }

    public Orders(int customerid, String status) {
        Customerid = customerid;
        Status = status;
    }

    public Orders() {
    }

    public void setCustomerid(int customerid) {
        Customerid = customerid;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", Customerid=" + Customerid + ", OrderTime=" + OrderTime + ", Status=" + Status
                + "]";
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        OrderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


//package com.sunbeam.entity;
//
//public class Orders {
//	private int price_id;
//	private int cust_id;
//	private String size;
//	private int price;
//	
//	
//	
//	public Orders(int price_id, int cust_id, String size, int price) {
//		this.price_id = price_id;
//		this.cust_id = cust_id;
//		this.size = size;
//		this.price = price;
//	}
//
//	
//
//
//	public int getPrice_id() {
//		return price_id;
//	}
//
//
//
//
//	public void setPrice_id(int price_id) {
//		this.price_id = price_id;
//	}
//
//
//
//
//	public int getCust_id() {
//		return cust_id;
//	}
//
//
//
//
//	public void setCust_id(int cust_id) {
//		this.cust_id = cust_id;
//	}
//
//
//
//
//	public String getSize() {
//		return size;
//	}
//
//
//
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//
//
//
//	public int getPrice() {
//		return price;
//	}
//
//
//
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//
//
//
//	@Override
//	public String toString() {
//		return "Orders [price_id=" + price_id + ", cust_id=" + cust_id + ", size=" + size + ", price=" + price + "]";
//	}
//	
//	
//	
//	
//	
//	
//}
