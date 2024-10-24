package com.sunbeam.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;

@Component
public class MobileForm2MobileConverter implements Converter<MobileForm, Mobile>{

	@Override
	public Mobile convert(MobileForm m) {
	   
		String name = m.getImageFile().getOriginalFilename();
		Mobile mob = new Mobile(m.getId(),m.getName(),m.getRam(),m.getStorage(),m.getCompany(),m.getPrice(),name);
		return mob;
	}

}
