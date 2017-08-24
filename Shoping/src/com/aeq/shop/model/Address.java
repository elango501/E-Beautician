package com.aeq.shop.model;

public class Address {
int id;
int userid;
String username;
String Street;
String Place;
String city;
String zipcode;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStreet() {
	return Street;
}
public void setStreet(String street) {
	Street = street;
}
public String getPlace() {
	return Place;
}
public void setPlace(String place) {
	Place = place;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
@Override
public String toString() {
	return "Address [id=" + id + ", userid=" + userid + ", username="
			+ username + ", Street=" + Street + ", Place=" + Place + ", city="
			+ city + ", zipcode=" + zipcode + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Place == null) ? 0 : Place.hashCode());
	result = prime * result + ((Street == null) ? 0 : Street.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + id;
	result = prime * result + userid;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
	Address other = (Address) obj;
	if (Place == null) {
		if (other.Place != null)
			return false;
	} else if (!Place.equals(other.Place))
		return false;
	if (Street == null) {
		if (other.Street != null)
			return false;
	} else if (!Street.equals(other.Street))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (id != other.id)
		return false;
	if (userid != other.userid)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	if (zipcode == null) {
		if (other.zipcode != null)
			return false;
	} else if (!zipcode.equals(other.zipcode))
		return false;
	return true;
}
}
