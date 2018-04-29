package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfigApp;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
	
	static {
		System.out.println("MyWebApplicationInitializer::Static Block");
	}
	
	public MyWebApplicationInitializer() {
		System.out.println("MyWebApplicationInitializer::0-param Constructor");
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("onStartUP(-)");
		
		
		AnnotationConfigWebApplicationContext rootCtx, webCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet ds=null;
		ServletRegistration.Dynamic registration=null;
		
		
		//Create IOC container having Configuration Class
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfigApp.class);
		
		webCtx=new AnnotationConfigWebApplicationContext();
		webCtx.register(WebMVCAppConfig.class);
		
		//Create And Register ContextLoaderListener
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		
		//Create DispacherServlet
		ds=new DispatcherServlet(webCtx);
		registration=sc.addServlet("dispatcher", ds);
		registration.addMapping("*.htm");
		registration.setLoadOnStartup(1);
		
		
		
	}

	
	
}
