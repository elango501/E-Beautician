package com.aeq.shop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aeq.shop.com.Dbconnection;
import com.aeq.shop.model.User;

public class UserDaoImp {
Connection con;
PreparedStatement statement;
 public UserDaoImp(){
	con=Dbconnection.getConnection();
}
public void addUser(User user){
	String query="insert into tbl_reg(name,email,password,gender,age,role) VALUES(?,?,?,?,?,?)";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getGender());
		statement.setInt(5, user.getAge());
		
		statement.setString(6, user.getRole());
		statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void update(User user){
	String query="update tbl_reg set name=?, email=?, password=?,gender=?,age=?, role=? where id=?";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getGender());
		statement.setInt(5, user.getAge());

		statement.setString(6, user.getRole());
		statement.setInt(7, user.getId());
		statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<User> listUser(){
	List<User> list=new ArrayList<User>();
	String query="select * from tbl_reg";
	try {
		statement=con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setAge(rs.getInt("age"));
			
			user.setRole(rs.getString("role"));
			list.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	
}
public void deleteUser(int id){
	String query="delete from tbl_reg where id=?";
	try {
		statement=con.prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public User getbyId(int id){
	String query="select * from tbl_reg where id=?";
	User user=new User();
	try {
		statement=con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs;
		rs = statement.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setAge(rs.getInt("age"));
	
			user.setRole(rs.getString("role"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return user;
}
public int login(String email,String password){
	int result=0;
	String query="select * from tbl_reg where email=? and password=?";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			result=1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result;
}
public String getbyrole(String email,String password){
	String role = null;
	String query="select role from tbl_reg where email=? and password=?";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			role=rs.getString("role");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return role;
}
public int count_customer(){
	String query="select count(id) from tbl_reg  where role='customer'";
	int count = 0;
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
public List<User> profile(String email,String password){
	List<User> list=new ArrayList<User>();
	String query="select * from tbl_reg where email=? and password=?";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet rs=statement.executeQuery();
		
		if(rs.next()){
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setAge(rs.getInt("age"));
			
			user.setRole(rs.getString("role"));
			list.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return list;
}
public int loginid(String email,String password){
	int loginid=0;
	String query="select id from tbl_reg where email=? and password=?";
	try {
		statement=con.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet rs=statement.executeQuery();
		while(rs.next()){
			loginid=rs.getInt("id");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return loginid;
	
}
}
