package com.sunbeam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.entity.Dir;
import com.sunbeam.entity.Movie;
import com.sunbeam.entity.User;
import com.sunbeam.service.MovieServ;

@Controller
public class MovieController {

	@Autowired
	private MovieServ movieServ;

	@RequestMapping("/movies")
	public String movieList(Model model, HttpSession session) {
		List<Movie> list = movieServ.getAll();
		User loginUser = (User) session.getAttribute("user");
		model.addAttribute("movieList", list);
		model.addAttribute("loginUser", loginUser);
		return "movies";
	}
	
	@GetMapping("/addmovie")
	public String addDirector() {
		return "mov";
	}

	@PostMapping("/addmovie")
	public String addDir(Movie mov) {
		Movie move = movieServ.addMov(mov);
		return "redirect:movies";
	}

	
}
