/**
 * 
 */
package com.erasolon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author operator_erasolon
 *
 */

@Controller
public class UserController {
	
	 @GetMapping("/user")
	 public String greetingUser() {
		 return "/user";
	 }
	 
	 @GetMapping("/admin")
	 public String greetingAdmin() {
		 return "/admin";
	 }
	 
	 @GetMapping("/forbidden")
	 public String forbidden() {
		 return "/forbidden";
	 }
	 

}
