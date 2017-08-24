package com.aeq.shop.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aeq.shop.com.Dbconnection;
import com.aeq.shop.model.Order_Product;
import com.aeq.shop.model.Product;

public class ProductDaoImp {
	Connection con;
	PreparedStatement statement;
	public  ProductDaoImp(){
		con=Dbconnection.getConnection();
	}
	public void addProduct(Product product){
		String query="insert into tbl_product(productname,price,batchno,quantity,accesories) VALUES(?,?,?,?,?)";
		try {
			statement=con.prepareStatement(query);
			statement.setString(1, product.getProductname());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getBatchno());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getAccesories());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Product> listproduct(){
		List<Product> list=new ArrayList<Product>();
		String query="select * from tbl_product";
		try {
			statement=con.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getDouble("price"));
				product.setBatchno(rs.getString("batchno"));
				product.setQuantity(rs.getInt("quantity"));
				product.setAccesories(rs.getString("accesories"));
				list.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void update_product(Product product){
		String query="update tbl_product set productname=?, price=?, batchno=?,quantity=?,accesories=? where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setString(1, product.getProductname());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getBatchno());
			statement.setInt(4, product.getQuantity());
			statement.setString(5, product.getAccesories());
			statement.setInt(6, product.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delete_product(int id){
		String query="delete from tbl_product where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Product product_getbyid(int id){
		String query="select * from tbl_product where id=?";
		Product product=new Product();
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs;
			rs = statement.executeQuery();
			if(rs.next()){
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setPrice(rs.getDouble("price"));
				product.setBatchno(rs.getString("batchno"));
				product.setQuantity(rs.getInt("quantity"));
				product.setAccesories(rs.getString("accesories"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return product;
	}
	public int count_product(){
		int count=0;
		String query="SELECT count(id) FROM `tbl_product`";
		try {
			statement=con.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			while(rs.next()){
				count=rs.getInt("count(id)");
			}
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}
	public void afterorderupdate(int quantity,int productid){
		String query="update tbl_product set quantity=quantity-?  where id=?";
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, quantity);
			statement.setInt(2, productid);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int quantitygetbyid(int id){
		int qun=0;
		String query="select quantity from tbl_product where id=?";
		
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs;
			rs = statement.executeQuery();
			if(rs.next()){
				qun=rs.getInt("quantity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qun;
	}
public double priceqetbyid(int id){
		double price = 0;
String query="select price from tbl_product where id=?";
		
		try {
			statement=con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs;
			rs = statement.executeQuery();
			if(rs.next()){
				price=rs.getDouble("price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

}
