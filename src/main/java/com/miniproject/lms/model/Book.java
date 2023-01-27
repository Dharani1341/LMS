package com.miniproject.lms.model;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//import jakarta.persistence.Entity;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	
	private int bookId;
	
	
	
	private String name;
	private String author;
	private double version;
	private int release_year;
	private String book_type;

	private Date issuedDate;
	private Date returnDate;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

//	public Book(int bookId, String name, String author, double version, int release_year, String book_type
//			) {
//		super();
//		this.bookId = bookId;
//		this.name = name;
//		this.author = author;
//		this.version = version;
//		this.release_year = release_year;
//		this.book_type = book_type;
//	}

	public Book() {

	}

public Book(int bookId, String name, String author, double version, int release_year, String book_type)
		 {
	super();
	this.bookId = bookId;
	this.name = name;
	this.author = author;
	this.version = version;
	this.release_year = release_year;
	this.book_type = book_type;
//	this.issuedDate = issuedDate;
//	this.returnDate = returnDate;
}

}
