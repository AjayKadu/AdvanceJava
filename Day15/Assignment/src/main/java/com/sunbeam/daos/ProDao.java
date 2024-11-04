package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Products;

public interface ProDao extends JpaRepository<Products, Integer>{

}
