package com.aeq.shop.daoimp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aeq.shop.com.Dbconnection;
import com.aeq.shop.model.Order;
import com.aeq.shop.model.Order_Product;
import com.aeq.shop.model.Product;





import com.aeq.shop.model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderproductDaoImp {
Connection con;
PreparedStatement statement;
ProductDaoImp productdaoimp;
UserDaoImp userdaoimp;
   public OrderproductDaoImp (){
		con=Dbconnection.getConnection();
		productdaoimp=new ProductDaoImp();
		userdaoimp=new UserDaoImp();
}

public void addorder_bulkproduct(int userid,String orderno,int productid,int quantity,double price){
	String query="insert into tbl_order(userid,orderno,productid,quantity,price) VALUES(?,?,?,?,?)";
	try {
		statement=con.prepareStatement(query);
	
		statement.setInt(1, userid);
		statement.setString(2, orderno);
		
		statement.setInt(3, productid);
		statement.setInt(4, quantity);
		statement.setDouble(5, price);
		
		statement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<Order> lisrorder(){
	List<Order> list=new ArrayList<Order>();
	String query="select * from tbl_order";
	
	try {
		statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			Order order=new Order();
			order.setId(rs.getInt("id"));
			order.setPrductid(rs.getInt("productid"));
			order.setUserid(rs.getInt("userid"));
			order.setQuantity(rs.getInt("quantity"));
			order.setPrice(rs.getDouble("price"));
			order.setOrderno(rs.getString("orderno"));
			Product product=productdaoimp.product_getbyid(rs.getInt("productid"));
			User user=userdaoimp.getbyId(rs.getInt("userid"));
			order.setUsername(user.getEmail());
			order.setProduct(product.getProductname());
			list.add(order);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}


public void deleteorderproduct(String orderno){
	String query="delete from tbl_order where orderno=? and status!='deliverd'";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, orderno);
		statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Order> myorderno(int userid){
	List<Order> list=new ArrayList<Order>();
	String query="SELECT distinct orderno,userid,status  FROM `reg`.`tbl_order` where userid=?";
	
	try {
		statement=con.prepareStatement(query);
		statement.setInt(1, userid);
		ResultSet rs;
		rs = statement.executeQuery();
		while(rs.next()){
			Order order=new Order();
			order.setUserid(rs.getInt("userid"));
			order.setOrderno(rs.getString("orderno"));
			order.setStatus(rs.getString("status"));
			
			list.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}
public List<Order> viewmybyorderno(String orderno){
	List<Order> list=new ArrayList<Order>();
	String query="select id, productid,quantity,price from tbl_order where orderno=?";
	
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, orderno);
		ResultSet rs;
		rs = statement.executeQuery();
		while(rs.next()){
			Order order=new Order();
			order.setId(rs.getInt("id"));
			order.setPrductid(rs.getInt("productid"));
			
			order.setQuantity(rs.getInt("quantity"));
			order.setPrice(rs.getDouble("price"));
		
			Product product=productdaoimp.product_getbyid(rs.getInt("productid"));
			
			order.setProduct(product.getProductname());
			list.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}
public JSONArray ordergetbyuser(int userid){
	JSONArray jsonarray=new JSONArray();
	String query="select distinct orderno from tbl_order where  userid=? and status!='deliverd'";
	
	try {
		statement=con.prepareStatement(query);
		statement.setInt(1, userid);
		ResultSet rs;
		rs = statement.executeQuery();
		while(rs.next()){
			 JSONObject obj=new JSONObject();
			
			 try {
				obj.put("orderno", rs.getInt("orderno"));
				jsonarray.put(obj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
				
			
	
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return jsonarray;
}
public void afterdeliverdupdate(int orderid){
	String query="update tbl_order set status='deliverd'  where orderno=?";
	try {
		statement=con.prepareStatement(query);
		statement.setInt(1, orderid);
		statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public int countnooforder(){
	int count=0;
	String query="SELECT count(id) FROM `reg`.`tbl_order` where status='deliverd'";
	try {
		statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			count=rs.getInt("count(id)");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return count;
	
}
public int countnooforderproduct(){
	int count=0;
	String query="SELECT count(id) FROM `reg`.`tbl_order`";
	try {
		statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			count=rs.getInt("count(id)");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return count;
	
}
public List<Order> grandtotal(String orderno){
	List<Order> list=new ArrayList<Order>();
	String query="SELECT sum(quantity) as quantityproduct ,sum(price) totalamount FROM `reg`.`tbl_order` where  orderno=?";
	
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, orderno);
		ResultSet rs;
		rs = statement.executeQuery();
		while(rs.next()){
			Order order=new Order();
			
		order.setQuantity_product(rs.getString("quantityproduct"));
		order.setTotalamount(rs.getString("totalamount"));
			list.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}
}
