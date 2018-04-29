package com.nt.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ShowHomeController {
	
	@RequestMapping("/home.htm")
	public String ShowHomePage() {
		return "welcome";
	}

}
