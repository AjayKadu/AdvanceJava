package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.entity.Movie;

@Service
public class MovieServImp implements MovieServ {

	@Autowired
	private MovieDao mDao;
	
	@Override
	public List<Movie> getAll() {
		List<Movie> list = mDao.findAll();
		return list;
	}

	@Override
	public Movie addMov(Movie mov) {
		Movie m = new Movie(0, mov.getMovie_name(), mov.getActor(), mov.getActress(), mov.getRating());
		Movie move = mDao.save(m);
		return move;
	}

}
