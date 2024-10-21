package com.sunbeam.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;

public class AddCart_JSP {
   
	private String[] bookIds;
	private List<Book> list;

	public AddCart_JSP() {
		 this.list = new ArrayList<>();
	}

	public AddCart_JSP(String[] bookIds, List<Book> list) {
		this.bookIds = bookIds;
		this.list = list;
	}

	public String[] getBookIds() {
		return bookIds;
	}

	public void setBookIds(String[] bookIds) {
		this.bookIds = bookIds;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AddCart_JSP [bookIds=" + Arrays.toString(bookIds) + ", list=" + list + "]";
	}
	
	public void addCarts() {
		try(BookDao dao = new BookDao()){
			
			for(String id : bookIds) {
			int idx	= Integer.parseInt(id);
			  Book bk = dao.findById(idx);
			  this.list.add(bk);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

 