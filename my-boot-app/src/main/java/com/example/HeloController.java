package com.example;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0, "taro", "taro@yamada"));
		data.add(new DataObject(1, "hanako", "hanako@flower"));
		data.add(new DataObject(2, "sachiko", "sachiko@happy"));
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
