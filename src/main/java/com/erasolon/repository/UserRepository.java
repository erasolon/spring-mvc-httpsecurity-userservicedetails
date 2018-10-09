package com.erasolon.repository;

import com.erasolon.entity.Credentials;

/**
 * @author Emile 
 *
 * Created on  24/08/2018
 */

public interface UserRepository{
	
	public Credentials findByUsername(String username);

}
