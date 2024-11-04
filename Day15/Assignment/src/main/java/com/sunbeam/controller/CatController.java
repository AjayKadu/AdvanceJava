package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunbeam.Service.CatService;
import com.sunbeam.entities.Categories;

@Controller
public class CatController {
    
	@Autowired
	private CatService catServ;
	
	
	@GetMapping("/index")
	public String ShowAllCat(Model model) {
		
		List<Categories> list = catServ.getAllCat();
		model.addAttribute("catList", list);
		return "index";
		
	}
}
