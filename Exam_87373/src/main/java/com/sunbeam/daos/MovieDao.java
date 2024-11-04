package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entity.Movie;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
