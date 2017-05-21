package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.entity.Author;
import com.books.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/listOfAuthors", method = RequestMethod.GET)
	public String listOfAuthors(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "listOfAuthors";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@RequestParam String name, @RequestParam String surname) {

		Author author = new Author();
		author.setName(name);
		author.setSurname(surname);
		authorService.save(author);
		return "redirect:/listOfAuthors";
	}

	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String deleteUAuthor(@PathVariable int id) {

		authorService.delete(id);

		return "redirect:/listOfAuthors";
	}

	@RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.GET)
	public String getAuthor(@PathVariable int id, Model model) {
		model.addAttribute("authorAttribute", authorService.findOne(id));
		return "updateAuthor";
	}

	@RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.POST)
	public String updateAuthor(@ModelAttribute("authorAttribute") Author author, @PathVariable int id, Model model) {
		author.setId(id);
		authorService.save(author);
		model.addAttribute("authors", authorService.findAll());
		return "listOfAuthors";
	}

}
