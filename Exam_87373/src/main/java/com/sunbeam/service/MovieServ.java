package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entity.Movie;

public interface MovieServ {

	List<Movie> getAll();

	Movie addMov(Movie mov);

}
