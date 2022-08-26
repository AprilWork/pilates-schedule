package com.kukvar.hibernate.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users")
@Table(name="users")
public class Customers {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;	
	//@Column(name="username")
	//private String username;	
	@Column(name="password")
	private String password;
	@Column(name="phone")
	private String phone;	
	
	public Customers() {	}


	public Customers(String email, String password, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customers [email=" + email  + "]";
	}



}
