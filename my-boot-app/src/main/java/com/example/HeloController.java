package com.example;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		data.add(new String[]{"taro", "taro@yamada", "090-999-999"});
		data.add(new String[]{"hanako", "hanako@flower", "080-888-888"});
		data.add(new String[]{"sachiko", "sachiko@happy", "080-888-888"});
		model.addAttribute("data", data);
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
