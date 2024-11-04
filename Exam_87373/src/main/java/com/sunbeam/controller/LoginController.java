package com.sunbeam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entity.Cred;
import com.sunbeam.entity.Dir;
import com.sunbeam.entity.User;
import com.sunbeam.service.UserServ;

@Controller
public class LoginController {

	@Autowired
	private UserServ userServ;

	@PostMapping("/index")
	public String Login(Cred cr, HttpSession session) {

		User user = userServ.authenticate(cr);
		if (user != null) {
			session.setAttribute("user", user);

			if (user.getRole().equals("Admin"))
				return "redirect:directors";
			else {
				return "redirect:movies";
			}
		}
		return "failed";

	}

	@RequestMapping("/directors")
	public String directorList(Model model, HttpSession session) {
		
		List<User> list = userServ.getAll();
		User loginUser = (User) session.getAttribute("user");
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("directorList", list);
		
		return "director";
	}

	@GetMapping("/adddir")
	public String addDirector() {
		return "dir";
	}

	@PostMapping("/adddir")
	public String addDir(Dir dir) {
		User user = userServ.addDir(dir);
		return "redirect:directors";
	}

	@GetMapping("/index")
	public String Loginpage() {
		return "index";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
	   li	= userServ.deletedU(id);
	}
}
