package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/greeting")
	public String sayHello(Model model) {
		model.addAttribute("greeting", "hello world");
		return  "hello";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		System.out.println("inside index method @ Hello Controller");
		return "forward:index.jsp";
	}
	
}
