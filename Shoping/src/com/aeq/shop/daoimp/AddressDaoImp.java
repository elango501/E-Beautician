package com.aeq.shop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aeq.shop.com.Dbconnection;
import com.aeq.shop.model.Address;
import com.aeq.shop.model.User;


public class AddressDaoImp {
Connection con;
UserDaoImp userdaoimp;
PreparedStatement statement;
	public AddressDaoImp(){
		con=Dbconnection.getConnection();
		userdaoimp=new UserDaoImp();
	}
	
	public void insert_address(Address address){
		String query="insert into tbl_address(userid,street,place,city,zipcode) VALUES(?,?,?,?,?)";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, address.getUserid());
			statement.setString(2, address.getStreet());
			statement.setString(3, address.getPlace());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getZipcode());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update_address(Address address){
		String query="update tbl_address set  userid=?, street=?,place=?,city=?,zipcode=? where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, address.getUserid());
			statement.setString(2, address.getStreet());
			statement.setString(3, address.getPlace());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getZipcode());
			statement.setInt(6, address.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete_addresss(int id){
		String query="delete from tbl_address where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Address> list_useraddress(){
		List<Address> list=new ArrayList<Address>();
		String query="select * from tbl_address";
		try {
			statement=con.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Address address=new Address();
				address.setId(rs.getInt("id"));
				address.setUserid(rs.getInt("userid"));
				address.setStreet(rs.getString("street"));
				address.setPlace(rs.getString("place"));
				address.setCity(rs.getString("city"));
				address.setZipcode(rs.getString("zipcode"));
				User user=userdaoimp.getbyId(rs.getInt("userid"));
				address.setUsername(user.getEmail());
				list.add(address);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	public Address address_getbyid(int id){
		String query="select * from tbl_address where id=?";
		Address address=new Address();
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs;
			rs = statement.executeQuery();
			if(rs.next()){
				address.setId(rs.getInt("id"));
				address.setUserid(rs.getInt("userid"));
				address.setStreet(rs.getString("street"));
				address.setPlace(rs.getString("place"));
				address.setCity(rs.getString("city"));
				address.setZipcode(rs.getString("zipcode"));
				User user=userdaoimp.getbyId(rs.getInt("userid"));
				address.setUsername(user.getEmail());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return address;
	}
	public List<Address> myaddress(int userid){
		List<Address> list=new ArrayList<Address>();
		String query="select * from tbl_address where userid=?";
		Address address=new Address();
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, userid);
			ResultSet rs=statement.executeQuery();
			
			if(rs.next()){
				
				address.setId(rs.getInt("id"));
				address.setUserid(rs.getInt("userid"));
				address.setStreet(rs.getString("street"));
				address.setPlace(rs.getString("place"));
				address.setCity(rs.getString("city"));
				address.setZipcode(rs.getString("zipcode"));
				User user=userdaoimp.getbyId(rs.getInt("userid"));
				address.setUsername(user.getEmail());
				list.add(address);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	public String getaddresbyuser(int userid){
		String place="";
		String query="select place from tbl_address where userid=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, userid);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				place=rs.getString("place");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return place;
	}
	public int getaddresidbyuser(int userid){
		int placeid=0;
		String query="select id from tbl_address where userid=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, userid);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				placeid=rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return placeid;
	}
}
