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

import com.miniproject.lms.model.Student;
import com.miniproject.lms.serviceImpl.BookImpl;
import com.miniproject.lms.serviceImpl.StudentImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentImpl studentimpl;

	

	@Autowired
	BookImpl bookimpl;

	// ..To add a single Student
//	@PostMapping("/addStudent")
//	public String addStudentDetails(@RequestBody Student student) {
//		studentimpl.saveStudent(student);
//		return "Student Added";
//	}

	// ...To add multiple students
	@PostMapping("/addStudents")
	 ResponseEntity addAll(@RequestBody List<Student> student) {
		
		return new ResponseEntity<>("Number Of Students Added is : " + studentimpl.addAll(student),HttpStatus.OK);
		
	}

	// ..To get All Student Details
	@GetMapping("/getStudentDetails")
	public List<Student> getStudentDetails() {
		return studentimpl.getAll();
	}

	// ..To get a student by ID
	@GetMapping("/studentById/{id}")
	public 	Student getStudentById(@PathVariable int id) {
		return studentimpl.getStudentById(id);
	}

	@DeleteMapping("/deleteStudentById/{id}")
	ResponseEntity deleteStudentById(@PathVariable int id) {
		return new ResponseEntity<>("Deleted Student ID is: " +studentimpl.deleteStudentById(id),HttpStatus.OK);
	}


	@PutMapping("/updateStudentDetails")
	public Student updateStudent(@RequestBody Student modifiedstudent) {
		studentimpl.updateStudentDetails(modifiedstudent);
		return modifiedstudent;
		
	}


	@PutMapping("/enrolBook/{stdid}/{bookid}")
	public Student updateStudentWithBook(@PathVariable Integer stdid,@PathVariable Integer bookid) {
		return studentimpl.updateStudentBook(stdid,bookid);
	}
	
	@PutMapping("/upgradeStudentYear/{id}")
	public Student updateStudent(@PathVariable int id) {
		return studentimpl.updateStudentYear(id);
	}
}
