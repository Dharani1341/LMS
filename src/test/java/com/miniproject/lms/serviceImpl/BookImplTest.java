package com.miniproject.lms.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miniproject.lms.dao.BookRepo;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Student;

@ExtendWith(MockitoExtension.class)
class BookImplTest {

	@InjectMocks
	BookImpl bookImpl;

	@Mock
	BookRepo bookRepo;

	Book book;

	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		book = new Book();
		book.setBookId(1);
		book.setName("Java");
		book.setAuthor("James");
		book.setBook_type("Subject");
		book.setVersion(2.0);
		book.setIssuedDate(null); 
		book.setReturnDate(null);
	}

	@Test
	@DisplayName("Test to get all books")
	public void testGetBooks() {

		List<Book> books = new ArrayList<>();
		books.add(book);

		Mockito.when(bookRepo.findAll()).thenReturn(books);
		List<Book> expected = bookImpl.getBookList();
		assertEquals(books, expected);
	}

	@Test
	@DisplayName("Test to add books")
	public void testAddBooks() {

		List<Book> bookList = new ArrayList<>();
		Mockito.when(bookRepo.saveAll(bookList)).thenReturn(bookList);
		assertEquals(0, bookImpl.addAll(bookList));
	}

	@Test
	@DisplayName("Test to find a book by Id")
	public void testFindBookById() {

		Optional<Book> bookOp = Optional.of(book);
		Mockito.when(bookRepo.findById(book.getBookId())).thenReturn(bookOp);
		assertEquals(book, bookImpl.findByBookId(book.getBookId()));
	}

	@Test
	@DisplayName("Test to Delete book by Id")
	public void testDeleteBookById() {

		bookImpl.deleteById(book.getBookId());
		verify(bookRepo, times(1)).deleteById(book.getBookId());
	}

}
