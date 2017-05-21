package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.AuthorDao;
import com.books.entity.Author;
import com.books.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorDao authorDao;

	public Author save(Author author) {
		authorDao.save(author);
		return author;
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public Author findOne(int id) {
		return authorDao.findOne(id);
	}

	public void delete(int id) {
			authorDao.delete(id);
	}

	public Author update(Author author) {
		authorDao.save(author);
		return author;
	}

}
