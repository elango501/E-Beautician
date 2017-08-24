package com.aeq.shop.model;

public class Delivery {
int id;
int userid;
int orderid;
int addressid;
String username;
String orderno;
String address;
String ddate;
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
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getAddressid() {
	return addressid;
}
public void setAddressid(int addressid) {
	this.addressid = addressid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDdate() {
	return ddate;
}
public void setDdate(String ddate) {
	this.ddate = ddate;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + addressid;
	result = prime * result + ((ddate == null) ? 0 : ddate.hashCode());
	result = prime * result + id;
	result = prime * result + orderid;
	result = prime * result + ((orderno == null) ? 0 : orderno.hashCode());
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
	Delivery other = (Delivery) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (addressid != other.addressid)
		return false;
	if (ddate == null) {
		if (other.ddate != null)
			return false;
	} else if (!ddate.equals(other.ddate))
		return false;
	if (id != other.id)
		return false;
	if (orderid != other.orderid)
		return false;
	if (orderno == null) {
		if (other.orderno != null)
			return false;
	} else if (!orderno.equals(other.orderno))
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
	return "Delivery [id=" + id + ", userid=" + userid + ", orderid=" + orderid
			+ ", addressid=" + addressid + ", username=" + username
			+ ", orderno=" + orderno + ", address=" + address + ", ddate="
			+ ddate + "]";
}
}
