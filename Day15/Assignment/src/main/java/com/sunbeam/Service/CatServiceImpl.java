package com.sunbeam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CatDao;
import com.sunbeam.entities.Categories;



@Service
public class CatServiceImpl implements CatService {

	 @Autowired
	  private CatDao cdao;
	
	@Override
	public List<Categories> getAllCat() {
		List<Categories> list = cdao.findAll();
		return list;
		
	}

}
