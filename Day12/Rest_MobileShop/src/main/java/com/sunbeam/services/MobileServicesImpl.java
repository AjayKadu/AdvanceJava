package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MobileDao;
import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;

@Service
public class MobileServicesImpl implements MobileServices {
	
	@Autowired
	private MobileDao mobileDao;

	@Override
	public List<Mobile> showAllMobiles() {
	    List<Mobile> list = mobileDao.findAll(); 
	    return list;
	}

	@Override
	public Mobile showById(int id) {
		Mobile mob = mobileDao.findById(id);
		return mob;
	}

	@Override
	public int saveMobile(Mobile m) {
		int id = mobileDao.save(m);
		return id;
	}

	
}
