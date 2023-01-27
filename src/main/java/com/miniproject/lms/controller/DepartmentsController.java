package com.miniproject.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.lms.model.Departments;
import com.miniproject.lms.serviceImpl.BookImpl;
import com.miniproject.lms.serviceImpl.DepartmentsImpl;

@RestController
public class DepartmentsController {
	@Autowired
	DepartmentsImpl departmentsimpl;

	@GetMapping("/getDepartments")
	public List<Integer> displayDepartments() {
		return departmentsimpl.getAll();
	}

	@DeleteMapping("/deleteDepartments/{deptid}")
	public void addDepartments(@RequestBody int deptid) {
		departmentsimpl.deletedepts(deptid);

	}

}
