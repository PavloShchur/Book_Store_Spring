package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.entity.Book;
import com.books.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/listOfBooks", method = RequestMethod.GET)
	public String listOfBooks(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "listOfBooks";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@RequestParam String titleOfBook, @RequestParam int priceOfBook,
			@RequestParam String nameOfAuthor, @RequestParam String surnameOfAuthor,
			@RequestParam short yearOfPublishing) {
		Book book = new Book();
		book.setTitleOfBook(titleOfBook);
		book.setPriceOfBook(priceOfBook);
		book.setNameOfAuthor(nameOfAuthor);
		book.setSurnameOfAuthor(surnameOfAuthor);
		book.setYearOfPublishing(yearOfPublishing);
		bookService.save(book);
		return "redirect:/listOfBooks";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int id) {

		bookService.delete(id);

		return "redirect:/listOfBooks";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.GET)
	public String getBook(@PathVariable int id, Model model) {
		model.addAttribute("bookAttribute", bookService.findOne(id));
		return "updateBook";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("bookAttribute") Book book, @PathVariable int id, Model model) {
		book.setId(id);
		bookService.save(book);
		model.addAttribute("books", bookService.findAll());
		return "listOfBooks";
	}

}
