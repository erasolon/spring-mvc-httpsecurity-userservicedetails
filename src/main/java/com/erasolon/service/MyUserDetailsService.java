package com.erasolon.service;


import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.erasolon.entity.Authorities;
import com.erasolon.entity.Credentials;
import com.erasolon.entity.Roles;
import com.erasolon.repository.UserRepository;

/**
 * @author Emile
 * 
 * Created on 24/08/2018
 *
 */

@Service(value="myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	Log log = LogFactory.getLog(MyUserDetailsService.class);	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
				
		Credentials userObject = userRepository.findByUsername(username);
		
		
		
		if (userObject==null) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        }
				
		UserDetails userDetails = (UserDetails) User.withUsername(userObject.getUsername())
				.password(passwordEncoder.encode(userObject.getPassword()))
				.authorities(getAuthorities(userObject))
				.roles(getRoles(userObject))
				.disabled(userObject.isDisabled())
				.build();
		
		return userDetails;
	}
	
	private Set<GrantedAuthority> getAuthorities(Credentials userObject){
        Set<GrantedAuthority > authorities = new HashSet<GrantedAuthority>();
        for(Authorities authority : userObject.getListAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
	
	private String[] getRoles(Credentials userObject){
        
        int i = 0;
        String[] roles = new String[userObject.getRoles().size()];
        
        for(Roles role : userObject.getRoles()) {
        	roles[i] = role.getRole();
        	i++;
        } 
        
        return roles;
    }
	

}
