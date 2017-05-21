package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.entity.Genre;
import com.books.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/listOfGenres", method = RequestMethod.GET)
	public String listOfGenres(Model model) {
		model.addAttribute("genres", genreService.findAll());
		return "listOfGenres";
	}

	@RequestMapping(value = "/saveGenre", method = RequestMethod.POST)
	public String saveGenre(@RequestParam String genreOfBook) {

		Genre genre = new Genre();
		genre.setGenreOfBook(genreOfBook);
		genreService.save(genre);
		return "redirect:/listOfGenres";
	}

	@RequestMapping(value = "/deleteGenre/{id}", method = RequestMethod.GET)
	public String deleteGenre(@PathVariable int id) {

		genreService.delete(id);

		return "redirect:/listOfGenres";
	}

	@RequestMapping(value = "/updateGenre/{id}", method = RequestMethod.GET)
	public String getGenre(@PathVariable int id, Model model) {
		model.addAttribute("genreAttribute", genreService.findOne(id));
		return "updateGenre";
	}

	@RequestMapping(value = "/updateGenre/{id}", method = RequestMethod.POST)
	public String updateGenre(@ModelAttribute("genreAttribute") Genre genre, @PathVariable int id, Model model) {
		genre.setId(id);
		genreService.save(genre);
		model.addAttribute("genres", genreService.findAll());
		return "listOfGenres";
	}

}
