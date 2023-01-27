package com.miniproject.lms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.lms.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
	String deleteByName(String name);



}
