package com.sunbeam.bean;

import java.util.List;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;

public class Book_JSP {
     
	private List<Book> list;
	private String subject;
	
	public Book_JSP() {
		
	}

	public Book_JSP(List<Book> list, String subject) {
		this.list = list;
		this.subject = subject;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Book_JSP [list=" + list + ", subject=" + subject + "]";
	}
	
	public void showBooks() {
		
		try(BookDao dao = new BookDao()){
			
			 this.list = dao.findBySubject(this.subject);
			 if(list.isEmpty()) {
				 System.out.println("No list");
				 
			 }
			 else {
				 System.out.println("list is present");
			 }
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
