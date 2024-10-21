package com.sunbeam.bean;

import java.util.List;

import com.sunbeam.daos.BookDao;

public class Subject_JSP {
    
	private List<String> list;
	
	public Subject_JSP() {
		
	}

	public Subject_JSP(List<String> list) {
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Subject_JSP [list=" + list + "]";
	}
	
	public void showSubjects() {
		
		try(BookDao dao = new BookDao()){
			
			this.list = dao.findAllSubjects();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
