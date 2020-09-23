package com.pluralsight.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LoginController {

	@GetMapping("/login/basic")
	public Principal basicLogin(Principal principal) {
		return principal;
	}
	
}
