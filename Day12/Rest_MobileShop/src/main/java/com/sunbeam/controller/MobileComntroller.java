package com.sunbeam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.converter.MobileForm2MobileConverter;
import com.sunbeam.entities.Mobile;
import com.sunbeam.entities.MobileForm;
import com.sunbeam.model.Result;
import com.sunbeam.pojos.User;
import com.sunbeam.services.MobileServices;
import com.sunbeam.services.UserServices;

@RestController
public class MobileComntroller {

	@Autowired
	private MobileServices mobileServices;

	@Value("${images.path}")
	private String imageFolder;

	@GetMapping("/mobiles")
	public Result getAllMobiles() {
		List<Mobile> list = mobileServices.showAllMobiles();
		return Result.success(list);

	}

	@GetMapping("/mobile/{id}")
	public Result getById(@PathVariable("id") int id) {
		Mobile mob = mobileServices.showById(id);
		return Result.success(mob);

	}

	@GetMapping(value = "/images/{imagename}", produces = "images/jpeg")
	public void download(@PathVariable("imagename") String imagename, HttpServletResponse resp) throws IOException {
		FileInputStream fin = new FileInputStream(imageFolder + imagename);
		FileCopyUtils.copy(fin, resp.getOutputStream());
		fin.close();
	}
	
	@Autowired
	private MobileForm2MobileConverter mobileForm2Mobile;
	
	@PostMapping(value="/mobiles", consumes = "multipart/form-data")
	public Result uploadImage(@ModelAttribute MobileForm m) throws IllegalStateException, IOException {
	MultipartFile infile = m.getImageFile();
	String fileName = infile.getOriginalFilename();
			
		File outFile = new File(imageFolder+fileName);
		infile.transferTo(outFile);
		Mobile mob = mobileForm2Mobile.convert(m);
		int id = mobileServices.saveMobile(mob);
		mob.setId(id);
		return Result.success(mob);
	}
	

}
