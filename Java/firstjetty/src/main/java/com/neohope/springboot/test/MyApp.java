package com.neohope.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude={xxx.class})
//@EnableConfigurationProperties(MyProperties.class)
public class MyApp 
{
	/**
	 * spring boot entry point
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApp.class, args);
	}
}
