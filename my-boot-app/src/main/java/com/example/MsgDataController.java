package com.example;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repositories.MsgDataRepository;

@Controller
public class MsgDataController {
	
	@Autowired
	MsgDataRepository repository;
	
//	@PersistenceContext
	EntityManager entityManager;
	
	MsgDataDaoImpl msgDataDaoImpl;
	
	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public String msg(Model model) {
		model.addAttribute("title", "Sample");
		model.addAttribute("msg", "MsgDataのサンプルです。");
		MsgData msgData = new MsgData();
		model.addAttribute("formModel", msgData);
		List<MsgData> list = msgDataDaoImpl.getAll();
		model.addAttribute("datalist", list);
		return "showMsgData";
	}
	
	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public String msgForm(@ModelAttribute @Valid MsgData msgData, Errors result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Sample [ERROR]");
			model.addAttribute("msg", "値を再チェックしてください!");
			return "showMsgData";
		} else {
			repository.saveAndFlush(msgData);
			return "redirect:/msg";
		}
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ok");
		msgDataDaoImpl = new MsgDataDaoImpl(entityManager);
	}

}
