package com.miniproject.lms.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.lms.dao.BookRepo;
import com.miniproject.lms.exception.AddressCannotBeEmpty;
import com.miniproject.lms.exception.AuthorNameCannotBeEmpty;
import com.miniproject.lms.exception.AuthorNameCannotBeNull;
import com.miniproject.lms.exception.BookAlreadyTaken;
import com.miniproject.lms.exception.BookAuthorCannotBeEmpty;
import com.miniproject.lms.exception.BookImplException;
import com.miniproject.lms.exception.BookNameCannotBeEmpty;
import com.miniproject.lms.exception.BookNameCannotBeNull;
import com.miniproject.lms.exception.BookNotFound;
import com.miniproject.lms.exception.BookTypeCannotBeEmpty;
import com.miniproject.lms.exception.BookTypeCannotBeNull;
import com.miniproject.lms.exception.DateCannotBeNull;
import com.miniproject.lms.exception.InvalidAddressDetails;
import com.miniproject.lms.exception.InvalidAddressInput;
import com.miniproject.lms.exception.InvalidAuthorName;
import com.miniproject.lms.exception.InvalidCountryName;
import com.miniproject.lms.exception.StudentNameCannotBeNull;
import com.miniproject.lms.exception.StudentNameCannotBeEmpty;
import com.miniproject.lms.exception.NoNegativeBatchYear;
import com.miniproject.lms.exception.NoNegativeReleaseYear;
import com.miniproject.lms.exception.NoNegativeVersion;
import com.miniproject.lms.exception.StudentNotFound;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Student;
import com.miniproject.lms.service.BookService;

import io.micrometer.common.util.StringUtils;

@Service
public class BookImpl implements BookService {

	@Autowired
	BookRepo bookRepo;


	public List<Book> getBookList() {
		List<Book> bookList = new ArrayList<>();
		try {
			bookList = bookRepo.findAll();
		} catch (Exception e) {
			System.out.println("Failed to fetch books");
		}
		return bookList;
	}

	public List<Book> booklist = getBookList();

	public String deleteByName(String name) {
		for (Book eachBook : booklist) {
			if (eachBook.getName().equalsIgnoreCase(name)) {
				bookRepo.deleteByName(name);

			} else {
				throw new BookNotFound();
			}
		}

		return "Book Deleted";
	}

	public static void checkBookname(String name) throws BookNameCannotBeEmpty, BookNameCannotBeNull {
		try {
			if (name.isBlank()) {
				throw new BookNameCannotBeEmpty();
			}
		} catch (NullPointerException e) {
			throw new BookNameCannotBeNull();
		}
	}

	public static void checkBookAuthor(String name)
			throws AuthorNameCannotBeEmpty, AuthorNameCannotBeNull, InvalidAuthorName {
		try {
			if (name.isBlank()) {
				throw new AuthorNameCannotBeEmpty();
			}
		} catch (NullPointerException e) {
			throw new AuthorNameCannotBeNull();
		}
		if (!Character.isLetter(name.charAt(0))) {
			throw new InvalidAuthorName();
		}
		int length = name.length();
		for (int index = 0; index < length; index++) {
			if (!(Character.isLetter(name.charAt(index)) || Character.isWhitespace(name.charAt(index)))) {
				throw new InvalidAuthorName();
			}
		}

	}

	public static void checkBookType(String name) throws BookTypeCannotBeEmpty, BookTypeCannotBeNull {
		try {
			if (name.isBlank()) {
				throw new BookNameCannotBeEmpty();
			}
		} catch (NullPointerException e) {
			throw new BookTypeCannotBeNull();
		}
	}


//	public Book addBooks(Book book) {
//		
//		if (StringUtils.isBlank(book.getName())) {
//			throw new StudentNameCannotBeNull();
//		}
//		if (StringUtils.isBlank(book.getAuthor())) {
//			throw new StudentNameCannotBeNull();
//		}
//		if (StringUtils.isBlank(book.getBook_type())) {
//			throw new StudentNameCannotBeNull();
//		}
//		try {
//		bookRepo.save(book);
//		}catch(Exception e) {
//			System.out.println("Exception"+e);
//		}
//      return book;
//	}


	public int addAll(List<Book> book) {
		List<Book> booklist = book;
		for (Book eachBook : booklist) {
			checkBookname(eachBook.getName());
			checkBookAuthor(eachBook.getAuthor());
			checkBookType(eachBook.getBook_type());
//			if (StringUtils.isBlank(eachBook.getAuthor())) {
//				throw new AuthorNameCannotBeEmpty();
//			}
//			if (StringUtils.isBlank(eachBook.getBook_type())) {
//				throw new BookTypeCannotBeEmpty();
//			}
			if ((eachBook.getVersion() < 0)) {
				throw new NoNegativeVersion();
			}
			if ((eachBook.getRelease_year() < 0)) {
				throw new NoNegativeReleaseYear();
			}
			if ((eachBook.getIssuedDate() == null)) {
				throw new DateCannotBeNull();
			}
			if ((eachBook.getReturnDate() == null)) {
				throw new DateCannotBeNull();
			}
		}
		try {
			bookRepo.saveAll(book);

		} catch (Exception e) {
			System.out.println("Exception while adding Books" + e);
		}
		return book.size();
	}



	public Book findByBookId(int id) {
		try {
			return bookRepo.findById(id).get();
		} catch (Exception e) {
			System.out.println("Book Not Found");
			throw new BookNotFound();
		}
	}


	public int deleteById(int id) {
		try {
			bookRepo.deleteById(id);
		} catch (Exception e) {
			System.out.println("Book is not found");
			throw new BookNotFound();
		}
		return id;

	}

	public void updateBook(Book modifiedBook) {
		try {
			Book book = findByBookId(modifiedBook.getBookId());
		} catch (Exception e) {
			System.out.println("Book is not found");
			throw new BookNotFound();
		}
		checkBookname(modifiedBook.getName());
		checkBookAuthor(modifiedBook.getAuthor());
		checkBookType(modifiedBook.getBook_type());

		if ((modifiedBook.getVersion() < 0)) {
			throw new NoNegativeVersion();
		}
		if ((modifiedBook.getRelease_year() < 0)) {
			throw new NoNegativeReleaseYear();
		}
		if ((modifiedBook.getIssuedDate() == null)) {
			throw new DateCannotBeNull();
		}
		if ((modifiedBook.getReturnDate() == null)) {
			throw new DateCannotBeNull();
		}
		try {
			bookRepo.save(modifiedBook);

		} catch (Exception e) {
			System.out.println("Exception while modifying Books" + e);
		}
	
	}

}
