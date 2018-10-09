package com.erasolon.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Emile
 *
 * Created 21/08/2018
 */

@Entity
public class Credentials {
	
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="disabled")
	private boolean disabled;
	
	@OneToMany(targetEntity=Roles.class, mappedBy="credentials", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Roles> roles;
	
	@OneToMany(targetEntity=Authorities.class, mappedBy="credentials", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Authorities> listAuthorities = new HashSet<Authorities>();

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public Set<Authorities> getListAuthorities() {
		return listAuthorities;
	}

	

}
