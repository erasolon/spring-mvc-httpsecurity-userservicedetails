package com.erasolon.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author erasolon
 * 
 * created on  17/08/2018
 */

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })  // disable default web password
@ComponentScan(basePackages = {"com.erasolon.config","com.erasolon.controller","com.erasolon.repository","com.erasolon.service"})
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
}
