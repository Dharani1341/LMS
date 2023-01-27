package com.miniproject.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.miniproject.lms.dao.BookRepo;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Student;

public interface BookService {
	
	public List<Book> getBookList();
	
	public String deleteByName(String name);
	
	public int addAll(List<Book> book);
	
//	public void updateByName(int id, String name);
//	
//	public void updateByAuthor(int id, String name);
//	
//	public void updateByVersion(int id, double version);
//	
//	public void updateByReleaseYear(int id, int releaseYear);
//	
//	public void updateByType(int id, String type);
//	
//	public int deleteById(int id);
	
}
