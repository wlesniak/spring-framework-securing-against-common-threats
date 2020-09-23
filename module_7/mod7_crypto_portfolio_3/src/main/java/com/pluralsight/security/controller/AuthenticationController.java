package com.pluralsight.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {

	@GetMapping("/user")
	public Principal principal(Principal principal) {
		return principal;
	}
	
}
