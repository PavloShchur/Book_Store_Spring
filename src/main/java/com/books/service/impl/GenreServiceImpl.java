package com.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.GenreDao;
import com.books.entity.Genre;
import com.books.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreDao genreDao;

	public Genre save(Genre genre) {
		return genreDao.save(genre);
	}

	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	public Genre findOne(int id) {
		return genreDao.findOne(id);
	}

	public void delete(int id) {
			genreDao.delete(id);
	}

	public Genre update(Genre genre) {
		return genreDao.save(genre);
	}



}
