package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Categories;

public interface CatDao extends JpaRepository<Categories, Integer> {

}
