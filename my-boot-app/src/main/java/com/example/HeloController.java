package com.example;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeloController {
	
	@RequestMapping("/{num}")
	public String index(@PathVariable int num, Model model) {
		model.addAttribute("num", num);
		if (num >= 0) {
			model.addAttribute("check", "num >= data.size() ? 0 : num");
		} else {
			model.addAttribute("check", "num <= data.size() * (-1) ? 0 : num * (-1)");
		}
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
