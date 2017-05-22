package com.neohope.springboot.test;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.neohope.ws.GetUser;
import com.neohope.ws.GetUserResponse;
import com.neohope.ws.ObjectFactory;
import com.neohope.ws.UserType;

@Endpoint
public class UserServiceEndpoint {
	private static final String NAMESPACE_URI = "http://tempuri.org/";
	
    private static String[] nameArray = { "张三", "李四", "王五", "赵六", "小明", "张伟", "王伟", "王芳", "李伟", "李娜", "张敏", "李静", "王静", "刘伟" };
    private static String[] sexArray = {"男", "女", "其他", "未知"}; 

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUser")
	@ResponsePayload
	public GetUserResponse getUser(@RequestPayload GetUser request) {
		ObjectFactory factory = new ObjectFactory();
		
		UserType ut = factory.createUserType();
		ut.setUserId(request.getUserId());
		ut.setUserName(factory.createString(nameArray[(int)(Math.random()*nameArray.length)]));
		ut.setUserSex(factory.createString(sexArray[(int)(Math.random()*sexArray.length)]));
		ut.setBirthDate(factory.createString(String.format("%04d-%02d-%02d", (int)(1987 + Math.random()*(30)), (int)(1 +  Math.random()*(12)), 1 +  (int)(Math.random()*(28)))));
		
		GetUserResponse response = factory.createGetUserResponse();
		response.setGetUserResult(factory.createUserType(ut));
		return response;
	}
}
