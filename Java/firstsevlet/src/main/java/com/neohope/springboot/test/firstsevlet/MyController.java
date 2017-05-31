package com.neohope.springboot.test.firstsevlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MyController {
	@Value("${spring.application.name}")
	private String appName;

	
	@RequestMapping("/hello")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/appName")
	String appName() {
		return appName;
	}
	
	/*
	 * Start the app with
	 * --appZone=neoZone
	 */
	String appZone="defaultZone";
	@RequestMapping("/appZone")
	String appZone() {
		return appZone;
	}
	
	
	@Autowired
	public MyController(ApplicationArguments args) {
		if(args.containsOption("appZone"))
		{
			List<String> nappzones = args.getOptionValues("appZone");
			if(nappzones!=null && nappzones.size()>0)
			{
				appZone=nappzones.get(0);
			}
		}
	}
}
