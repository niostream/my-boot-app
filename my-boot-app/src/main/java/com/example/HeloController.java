package com.example;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repositories.MyDataRepository;

@Controller
public class HeloController {
	
	@Autowired
	MyDataRepository repository;
	
	@Autowired
	private MyDataService service;
	
//	@PersistenceContext
	EntityManager entityManager;
	
	MyDataDaoImpl myDataDaoImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", "Find Page");
		model.addAttribute("msg", "MyDataのサンプルです。");
		List<MyData> list = service.getAll();
		model.addAttribute("datalist", list);
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public String form(@ModelAttribute("formModel") @Validated MyData myData, BindingResult result,
			Model model) {
		if (!result.hasErrors()) {
			repository.saveAndFlush(myData);
			return "redirect:/";
		} else {
			model.addAttribute("msg", "sorry, error is occurede...");
			List<MyData> list = repository.findAll();
			model.addAttribute("datalist", list);
			return "index";
		}
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@ModelAttribute MyData myData, @PathVariable long id, Model model) {
		model.addAttribute("title", "edit mydata.");
		Optional<MyData> data = repository.findById(id);
		model.addAttribute("formModel", data.get());
		return "edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String update(@ModelAttribute MyData myData, Model model) {
		repository.saveAndFlush(myData);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable long id, Model model) {
		model.addAttribute("title", "delete mydata.");
		Optional<MyData> data = repository.findById(id);
		model.addAttribute("formModel", data.get());
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public String remove(@RequestParam long id, Model model) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(Model model) {
		model.addAttribute("title", "Find page");
		model.addAttribute("msg", "MyDataのサンプルです。");
		model.addAttribute("value", "");
		List<MyData> list = service.getAll();
		model.addAttribute("datalist", list);
		return "find";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String search(HttpServletRequest request, Model model) {
		String param = request.getParameter("fstr");
		if ("".equals(param)) {
			return "redirect:/find";
		} else {
			model.addAttribute("title", "Find result");
			model.addAttribute("msg", "[" + param + "]の検索結果");
			model.addAttribute("value", param);
			List<MyData> list = service.find(param);
			model.addAttribute("datalist", list);
			return "find";
		}
	}
	
	@PostConstruct
	public void init() {
		myDataDaoImpl = new MyDataDaoImpl(entityManager);
		MyData d1 = new MyData();
		d1.setName("tuyano");
		d1.setAge(123);
		d1.setMail("syoda@tuyano.com");
		d1.setMemo("090999999");
		repository.saveAndFlush(d1);
		MyData d2 = new MyData();
		d2.setName("hanako");
		d2.setAge(15);
		d2.setMail("hanako@flower");
		d2.setMemo("080888888");
		repository.saveAndFlush(d2);
		MyData d3 = new MyData();
		d3.setName("sachiko");
		d3.setAge(37);
		d3.setMail("sachiko@happy");
		d3.setMemo("070777777");
		repository.saveAndFlush(d3);
	}
	
}
