package com.aeq.shop.model;

import java.io.Serializable;
import java.util.Date;

public class Order_Product implements Serializable {
int id;
int userid;
String username;
String orderno;
String orderdate;
String productname;
String model;
int quantity;
int modelid;
int productid;
double totalamount;
String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public String getOrderdate() {
	return orderdate;
}
public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getModelid() {
	return modelid;
}
public void setModelid(int modelid) {
	this.modelid = modelid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public double getTotalamount() {
	return totalamount;
}
public void setTotalamount(double totalamount) {
	this.totalamount = totalamount;
}
@Override
public String toString() {
	return "Order_Product [id=" + id + ", userid=" + userid + ", username="
			+ username + ", orderno=" + orderno + ", orderdate=" + orderdate
			+ ", productname=" + productname + ", model=" + model
			+ ", quantity=" + quantity + ", modelid=" + modelid
			+ ", productid=" + productid + ", totalamount=" + totalamount + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	result = prime * result + modelid;
	result = prime * result + ((orderdate == null) ? 0 : orderdate.hashCode());
	result = prime * result + ((orderno == null) ? 0 : orderno.hashCode());
	result = prime * result + productid;
	result = prime * result
			+ ((productname == null) ? 0 : productname.hashCode());
	result = prime * result + quantity;
	long temp;
	temp = Double.doubleToLongBits(totalamount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + userid;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order_Product other = (Order_Product) obj;
	if (id != other.id)
		return false;
	if (model == null) {
		if (other.model != null)
			return false;
	} else if (!model.equals(other.model))
		return false;
	if (modelid != other.modelid)
		return false;
	if (orderdate == null) {
		if (other.orderdate != null)
			return false;
	} else if (!orderdate.equals(other.orderdate))
		return false;
	if (orderno == null) {
		if (other.orderno != null)
			return false;
	} else if (!orderno.equals(other.orderno))
		return false;
	if (productid != other.productid)
		return false;
	if (productname == null) {
		if (other.productname != null)
			return false;
	} else if (!productname.equals(other.productname))
		return false;
	if (quantity != other.quantity)
		return false;
	if (Double.doubleToLongBits(totalamount) != Double
			.doubleToLongBits(other.totalamount))
		return false;
	if (userid != other.userid)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}


}
