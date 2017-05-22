package com.neohope.springboot.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	@RequestMapping("/jsp")
	String jsp(Map<String,Object> map){
        return "index";
    }
}
