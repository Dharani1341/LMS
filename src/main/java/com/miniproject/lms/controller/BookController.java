package com.miniproject.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Departments;
import com.miniproject.lms.model.Student;
import com.miniproject.lms.serviceImpl.BookImpl;

@RestController
@RequestMapping("/availablebooks")
public class BookController {
	@Autowired
	BookImpl bookimpl;

	
	@GetMapping("/getBookList")
	public List<Book> getBooks() {
		return bookimpl.getBookList();
	}

	// ..To Add a book(not list)
//	@PostMapping("/addBook")
//	public String addBooks(@RequestBody Book book) {
//		bookimpl.addBooks(book);
//		return "Book Added Successfully";
//	}

	@PostMapping("/addBooks")
	ResponseEntity addAllBooks(@RequestBody List<Book> book) {
		return new ResponseEntity<>("Number Of Books Added: "+bookimpl.addAll(book),HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteBook/{id}")
	ResponseEntity deleteBook(@PathVariable int id) {
		return new ResponseEntity<> ("Deleted Book With ID: " + bookimpl.deleteById(id),HttpStatus.OK);
	}
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book modifiedBook) {
		bookimpl.updateBook(modifiedBook);
		return modifiedBook;
	}
}
