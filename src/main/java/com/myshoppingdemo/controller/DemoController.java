package com.myshoppingdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

//	@GetMapping("/")
//	public String showHome() {
//		return "index";
//	}
	
	// add request mapping for /systems
	
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}

	@GetMapping("/addItem")
	public String addItem() {
		return "add_item";
	}

	@GetMapping("/account")
	public String showAccounts() {
		return "account";
	}
}










