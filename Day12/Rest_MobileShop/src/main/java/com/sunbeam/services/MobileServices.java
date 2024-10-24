package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;

public interface MobileServices {


	Mobile showById(int id);

	List<Mobile> showAllMobiles();

	int saveMobile(Mobile m);

}
