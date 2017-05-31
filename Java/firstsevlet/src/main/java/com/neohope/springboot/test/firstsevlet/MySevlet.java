package com.neohope.springboot.test.firstsevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("myservlet")  
public class MySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String pathTranslated = request.getPathTranslated();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		response.setContentType("application/json");
		response.getWriter().write("{");
		response.getWriter().write("\"pathInfo\":\"" + pathInfo + "\",");
		response.getWriter().write("\"pathTranslated\":\"" + pathTranslated + "\",");
		response.getWriter().write("\"contextPath\":\"" + contextPath + "\",");
		response.getWriter().write("\"servletPath\":\"" + servletPath + "\"");
		response.getWriter().write("}");
	}
}
