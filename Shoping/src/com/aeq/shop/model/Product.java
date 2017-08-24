package com.aeq.shop.model;

import java.io.Serializable;

public class Product implements Serializable {
int id;
String productname;
String batchno;
double price;
int quantity;
String accesories;
public String getAccesories() {
	return accesories;
}
public void setAccesories(String accesories) {
	this.accesories = accesories;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getBatchno() {
	return batchno;
}
public void setBatchno(String batchno) {
	this.batchno = batchno;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Product [id=" + id + ", productname=" + productname + ", batchno="
			+ batchno + ", price=" + price + ", quantity=" + quantity
			+ ", accesories=" + accesories + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((accesories == null) ? 0 : accesories.hashCode());
	result = prime * result + ((batchno == null) ? 0 : batchno.hashCode());
	result = prime * result + id;
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result
			+ ((productname == null) ? 0 : productname.hashCode());
	result = prime * result + quantity;
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
	Product other = (Product) obj;
	if (accesories == null) {
		if (other.accesories != null)
			return false;
	} else if (!accesories.equals(other.accesories))
		return false;
	if (batchno == null) {
		if (other.batchno != null)
			return false;
	} else if (!batchno.equals(other.batchno))
		return false;
	if (id != other.id)
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (productname == null) {
		if (other.productname != null)
			return false;
	} else if (!productname.equals(other.productname))
		return false;
	if (quantity != other.quantity)
		return false;
	return true;
}
}
