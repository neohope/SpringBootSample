package com.neohope.springboot.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private List<String> servers;
	
	public MyController(MyProperties props)
	{
		servers=props.getServers();
	}
	
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
	
	/**
	 * server list
	 * @return the server list
	 */
	@RequestMapping("/servers")
	String servers() {
		StringBuilder sb =new StringBuilder();
		this.servers.forEach(aServer->sb.append(aServer));
		return sb.toString();
	}
}
