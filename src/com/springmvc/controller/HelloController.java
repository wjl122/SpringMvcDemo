package com.springmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

	@RequestMapping( {"hello","/"})
	
	//@RequestParam("name")
	public String hello( String name,Model model) {
		System.out.println(name);
		model.addAttribute("name",name);
		model.addAttribute(name);
		return "hello";
	}
}
