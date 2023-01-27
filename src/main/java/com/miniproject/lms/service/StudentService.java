package com.miniproject.lms.service;

import java.util.List;

import com.miniproject.lms.exception.DepartmentImplException;
import com.miniproject.lms.model.Departments;
import com.miniproject.lms.model.Student;

public interface StudentService {
	
	
	public List<Student> getAll();
//	public void saveStudent(Student student);
	public int addAll(List<Student> student) throws DepartmentImplException;
	public Student getStudentById(int id);
	public int deleteStudentById(int id);
//	public Student updateStudentName(int id, String name);
//	public Student updateStudentBatchYear(int id, int batchyear);
//	public Student updateStudentDeptId(int id, int departmentId);
	public Student updateStudentBook(Integer stdid, Integer bookid);
	public Student updateStudentYear(int id);
	

}
