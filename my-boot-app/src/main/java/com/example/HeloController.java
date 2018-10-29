package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/{month}")
	public String index(@PathVariable int month, Model model) {
		int m = Math.abs(month) % 12;
		m = m == 0 ? 12 : m;
		model.addAttribute("month", month);
		model.addAttribute("check", Math.floor(m / 3));
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
