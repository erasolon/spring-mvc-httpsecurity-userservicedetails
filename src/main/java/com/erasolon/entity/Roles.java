package com.erasolon.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author erasolon
 *
 * created 21/08/2018	
 */


@Entity
public class Roles {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@Column(name="role")
	private String role;
	
	
	@ManyToOne(targetEntity=Credentials.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private Credentials credentials;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Credentials getCredentials() {
		return credentials;
	}


	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	
	
}
