package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class HelloController {
	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("msg", "Simple thymeleaf example");
		return "home";
 
	}
}