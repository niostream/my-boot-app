package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/{id}")
	public String index(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("check", id >= 0);
		model.addAttribute("trueVal", "POSITIVE!");
		model.addAttribute("falseVal", "negative...");
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
