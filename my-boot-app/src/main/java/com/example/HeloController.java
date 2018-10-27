package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello Spring-Boot World!";
	}
	
	String[] names = {
			"tuyano", "hanako", "taro", "sachiko", "ichiro"
	};
	String[] mails = {
			"syoda@tuuyano.com", "hanako@flower", "taro@yamada", "sachiko@happy", "ichiro@baseball"
	};
	
	@RequestMapping("/{id}")
	public DataObject index(@PathVariable int id) {
		return new DataObject(id, names[id], mails[id]);
	}
	
}
