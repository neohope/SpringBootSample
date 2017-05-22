package com.neohope.springboot.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Value("${spring.application.name}")
	private String appName;

	/**
	 * Tell the user spring boot is on.
	 * @return "It works!"
	 */
	@RequestMapping("/")
	String home() {
		return "It works!";
	}
	
	/**
	 * Tell the user app name.
	 * @return the app name
	 */
	@RequestMapping("/appName")
	String appName() {
		return appName;
	}
	
	/**
	 * add two nums
	 * @param a 
	 * @param b
	 * @return a+b
	 */
	@RequestMapping("/add")
	int add(int a, int b) {
		return a+b;
	}
}
