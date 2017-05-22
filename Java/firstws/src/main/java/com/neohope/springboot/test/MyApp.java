package com.neohope.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp 
{
	@Autowired
	public MyApp(ApplicationArguments args) {	
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApp.class, args);
		
		/*
		SpringApplication app = new SpringApplication();
		app.setBannerMode(Mode.OFF);
		app.run(args);
		
		new SpringApplicationBuilder()
		.child(MyApp.class)
		.bannerMode(Mode.OFF)
		.run(args);
		*/
	}
}
