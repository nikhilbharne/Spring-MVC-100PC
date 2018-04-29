package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.nt.controller")
public class WebMVCAppConfig {
	
	static{
		System.out.println("WebMVCAppConfig::Static Block");
	}
	
	public WebMVCAppConfig() {
		System.out.println("WebAppConfig::0-param Constructor");
	}
	
	public ViewResolver createIVResolver() {
		System.out.println("Create IVR Resolver()");
		
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver();
		ivr.setPrefix("WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		
		return ivr;
	}

}
