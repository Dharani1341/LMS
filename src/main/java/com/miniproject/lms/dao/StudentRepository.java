package com.miniproject.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
         public List<Student> findAll();

		//public List<Student> findById(int id);

		//public Book[] findAllByBook(Book book);
}
