package com.nt.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RootAppConfigApp {
	
	static {
		System.out.println("Static-Block");
	}
	
	public RootAppConfigApp() {
		System.out.println("0-param Constructor");
	}

}
