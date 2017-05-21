package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.entity.User;
import com.books.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("users", userService.findAll());
		return "signup";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String username, @RequestParam String useremail,
			@RequestParam String userpassword) {

		User user = new User();
		user.setName(username);
		user.setEmail(useremail);
		user.setPassword(userpassword);
		userService.save(user);
		return "redirect:/signup";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {

		userService.delete(id);

		return "redirect:/signup";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable int id, Model model) {
		model.addAttribute("userAttribute", userService.findOne(id));
		return "updateUser";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userAttribute") User user, @PathVariable int id, Model model) {
		user.setId(id);
		userService.save(user);
		model.addAttribute("users", userService.findAll());
		return "signup";
	}

}