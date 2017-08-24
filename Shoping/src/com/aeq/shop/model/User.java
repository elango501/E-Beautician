package com.aeq.shop.model;

import java.io.Serializable;

public class User implements Serializable {
int id;
String name;
String email;
String password;
String gender;
int age;
String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email
			+ ", password=" + password + ", gender=" + gender + ", age=" + age
			+ ", role=" + role + ", place=" + place + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((place == null) ? 0 : place.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	User other = (User) obj;
	if (age != other.age)
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (gender == null) {
		if (other.gender != null)
			return false;
	} else if (!gender.equals(other.gender))
		return false;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (place == null) {
		if (other.place != null)
			return false;
	} else if (!place.equals(other.place))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	return true;
}
String place;

}
