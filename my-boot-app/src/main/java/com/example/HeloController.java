package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/other")
	public String other() {
		return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "forward:/";
	}
	
}
