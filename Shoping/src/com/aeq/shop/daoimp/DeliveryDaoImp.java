package com.aeq.shop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aeq.shop.com.Dbconnection;
import com.aeq.shop.model.Address;
import com.aeq.shop.model.Delivery;
import com.aeq.shop.model.Order;
import com.aeq.shop.model.Order_Product;
import com.aeq.shop.model.User;

public class DeliveryDaoImp {
	Connection con;
	PreparedStatement statement;
	UserDaoImp userdaoimp;
	OrderproductDaoImp orderproductdaoimp;
	AddressDaoImp addressdaoimp;
	
	public DeliveryDaoImp(){
		con=Dbconnection.getConnection();
		userdaoimp=new UserDaoImp();
		addressdaoimp=new AddressDaoImp();
		orderproductdaoimp=new OrderproductDaoImp();
	}
	public void adddelivery(Delivery delivery){
		String query="insert into tbl_delivery(userid,orderid,addressid,ddate) VALUES(?,?,?,?)";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, delivery.getUserid());
			statement.setInt(2, delivery.getOrderid());
			statement.setInt(3, delivery.getAddressid());
			statement.setString(4, delivery.getDdate());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deletedelivery(int id){
		String query="delete from tbl_delivery where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 public List<Delivery> listdelivery(){
	 List<Delivery> list=new ArrayList<Delivery>();
	 String query="select * from tbl_delivery";
	 try {
		statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			Delivery delivery=new Delivery();
			delivery.setId(rs.getInt("id"));
			delivery.setUserid(rs.getInt("userid"));
			delivery.setAddressid(rs.getInt("addressid"));
			
			delivery.setDdate(rs.getString("ddate"));
			
			Address address=addressdaoimp.address_getbyid(rs.getInt("addressid"));
			User user=userdaoimp.getbyId(rs.getInt("userid"));
			
			delivery.setOrderno(rs.getString("orderid"));
			delivery.setUsername(user.getEmail());
			String add=address.getStreet()+""+address.getPlace()+""+address.getCity()+""+address.getZipcode();
			delivery.setAddress(add);
			list.add(delivery);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	return list;
	 
 }
 public Delivery getby_id(int id){
	 Delivery delivery=new Delivery();
	 String query="select * from tbl_delivery where id=?";
	 try {
		statement=con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			
			delivery.setId(rs.getInt("int"));
			delivery.setUserid(rs.getInt("userid"));
			delivery.setAddressid(rs.getInt("addressid"));
			delivery.setOrderid(rs.getInt("orderid"));
			delivery.setDdate(rs.getString("ddate"));
			//Order_Product order=orderproductdaoimp.getbyid(rs.getInt("orderid"));
			Address address=addressdaoimp.address_getbyid(rs.getInt("addressid"));
			User user=userdaoimp.getbyId(rs.getInt("userid"));
		
			delivery.setOrderno(rs.getString("orderid"));
			delivery.setUsername(user.getEmail());
			String add=address.getStreet()+""+address.getPlace()+""+address.getCity()+""+address.getZipcode();
			delivery.setAddress(add);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return delivery;
 }
 public List<Delivery> listdeliverybyorderno(int orderid){
	 List<Delivery> list=new ArrayList<Delivery>();
	 String query="select * from tbl_delivery where orderid=? ";
	 try {
		statement=con.prepareStatement(query);
		statement.setInt(1, orderid);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			Delivery delivery=new Delivery();
			delivery.setId(rs.getInt("id"));
			delivery.setUserid(rs.getInt("userid"));
			delivery.setAddressid(rs.getInt("addressid"));
			//delivery.setOrderid(rs.getInt("orderid"));
			delivery.setDdate(rs.getString("ddate"));
			//Order_Product order=orderproductdaoimp.getbyid(rs.getInt("orderid"));
			Address address=addressdaoimp.address_getbyid(rs.getInt("addressid"));
			User user=userdaoimp.getbyId(rs.getInt("userid"));
			
			delivery.setOrderno(rs.getString("orderid"));
			delivery.setUsername(user.getName());
			String add=address.getStreet()+""+address.getPlace()+""+address.getCity()+""+address.getZipcode();
			delivery.setAddress(add);
			list.add(delivery);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	return list;
	 
 }
}
