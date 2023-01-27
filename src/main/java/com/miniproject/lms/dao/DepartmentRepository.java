 package com.miniproject.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.lms.model.Departments;
import com.miniproject.lms.model.Student;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
   //List<Departments> findById(int id);
	public List<Departments> findAll();
	//public List<Integer> contains(int id);

	public void save(int deptid);
}
