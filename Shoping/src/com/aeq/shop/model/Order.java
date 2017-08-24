package com.aeq.shop.model;

public class Order {
int id;
int userid;
int prductid;
String product;
int quantity;
Double price;
String username;
String orderno;
String status;
String quantity_product;
String totalamount;
public String getQuantity_product() {
	return quantity_product;
}
public void setQuantity_product(String quantity_product) {
	this.quantity_product = quantity_product;
}
public String getTotalamount() {
	return totalamount;
}
public void setTotalamount(String totalamount) {
	this.totalamount = totalamount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getPrductid() {
	return prductid;
}
public void setPrductid(int prductid) {
	this.prductid = prductid;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + prductid;
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	result = prime * result + ((product == null) ? 0 : product.hashCode());
	result = prime * result + quantity;
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
	Order other = (Order) obj;
	if (id != other.id)
		return false;
	if (prductid != other.prductid)
		return false;
	if (price == null) {
		if (other.price != null)
			return false;
	} else if (!price.equals(other.price))
		return false;
	if (product == null) {
		if (other.product != null)
			return false;
	} else if (!product.equals(other.product))
		return false;
	if (quantity != other.quantity)
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
@Override
public String toString() {
	return "Order [id=" + id + ", userid=" + userid + ", prductid=" + prductid
			+ ", product=" + product + ", quantity=" + quantity + ", price="
			+ price + ", username=" + username + "]";
}
}
