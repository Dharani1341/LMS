package com.miniproject.lms.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.lms.dao.BookRepo;
import com.miniproject.lms.dao.StudentRepository;
import com.miniproject.lms.exception.AddressCannotBeEmpty;
import com.miniproject.lms.exception.BookAlreadyTaken;
import com.miniproject.lms.exception.BookNotFound;
import com.miniproject.lms.exception.DepartmentIdNotFound;
import com.miniproject.lms.exception.DepartmentImplException;
import com.miniproject.lms.exception.GraduationCompleted;
import com.miniproject.lms.exception.InvalidAddressDetails;
import com.miniproject.lms.exception.InvalidAddressInput;
import com.miniproject.lms.exception.InvalidCountryName;
import com.miniproject.lms.exception.InvalidName;
import com.miniproject.lms.exception.StudentNameCannotBeNull;
import com.miniproject.lms.exception.StudentNameCannotBeEmpty;
import com.miniproject.lms.exception.NoNegativeBatchYear;
import com.miniproject.lms.exception.PinCodeCannotBeNegative;
import com.miniproject.lms.exception.StudentNotFound;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Student;
import com.miniproject.lms.service.StudentService;


import io.micrometer.common.util.StringUtils;

@Service
public class StudentImpl implements StudentService {

	public StudentImpl() {

	}

	@Autowired
	StudentRepository studentrepo;

	@Autowired
	BookRepo bookrepo;

	@Autowired
	DepartmentsImpl departmentimpl;

	@Autowired
	BookImpl bookimpl;

	// ......To handle studentrepo null Exception
	public List<Student> getAll() {
		try {
			List<Student> studentList = studentrepo.findAll();
			return studentList;
		} catch (Exception e) {
			throw e;
		}
		
	}

	// ......Adding a student......
//	public void saveStudent(Student student) {
//		List<Integer> deptsList = new ArrayList<>();
//		try {
//			deptsList = departmentimpl.getAll();
//		} catch (Exception e) {
//			System.out.println("Failed to fetch department List");
//		}
//
//		if (StringUtils.isBlank(student.getName())) {
//			throw new StudentNameCannotBeNull();
//		}
//
//		if ((student.getBatch_year() < 0)) {
//			throw new NoNegativeBatchYear();
//		}
//		if (deptsList.contains(student.getDepartmentId()))
//
//		{
//			try {
//				studentrepo.save(student);
//			} catch (Exception e) {
//				System.out.println("Exception" + e);
//			}
//		} else {
//			throw new DepartmentIdNotFound();
//		}
//	}

	public static void checkName(String name) throws StudentNameCannotBeEmpty, StudentNameCannotBeNull,InvalidName {
		try {
			if (name.isBlank()) {
				throw new StudentNameCannotBeEmpty();
			}
		} catch (NullPointerException e) {
			throw new StudentNameCannotBeNull();
		}
		if (!Character.isLetter(name.charAt(0))) {
			throw new InvalidName();
		}
		int length = name.length();
		for (int index = 0; index < length; index++) {
			if (!(Character.isLetter(name.charAt(index)) || Character.isWhitespace(name.charAt(index)))) {
				throw new InvalidName();
			}
		}

	}

	public static void checkAddress(String name) throws InvalidAddressInput, AddressCannotBeEmpty {
		try {
			if (name.isBlank()) {
				throw new AddressCannotBeEmpty();
			}
		} catch (NullPointerException e) {
			throw new InvalidAddressDetails();
		}
		if (!Character.isLetter(name.charAt(0))) {
			throw new InvalidAddressInput();
		}
		int length = name.length();
		for (int index = 0; index < length; index++) {
			if (!(Character.isLetter(name.charAt(index)) || Character.isWhitespace(name.charAt(index)))) {
				throw new InvalidCountryName();
			}
		}

	}

	public int addAll(List<Student> student) throws DepartmentImplException {
		List<Student> studentList = student;
		List<Integer> deptsList = new ArrayList<>();
//		try {
//			deptsList = departmentimpl.getAll();
//		} catch (Exception e) {
//			System.out.println("Failed to fetch department List");
//		}
		try {
			deptsList = departmentimpl.getAll();
		}catch(Exception e) {
			throw new DepartmentImplException();
		}

		for (Student std : studentList) {
			if ((std.getAddress() == null)) {
				throw new AddressCannotBeEmpty();
			}
			checkName(std.getName());
			//checkAddress(std.getAddress().getStreet_name());
			if(StringUtils.isBlank(std.getAddress().getStreet_name())) {
				throw new InvalidAddressDetails();
			}
			if(StringUtils.isBlank(std.getAddress().getAddressline_1())){
				throw new InvalidAddressDetails();
			}
			if(StringUtils.isBlank(std.getAddress().getAddressline_2())) {
				throw new InvalidAddressDetails();
			}
			if(StringUtils.isBlank(std.getAddress().getCity())) {
				throw new InvalidAddressDetails();
			}
		
			checkAddress(std.getAddress().getCountry());

			if ((std.getBatch_year() < 0)) {
			
				throw new NoNegativeBatchYear();
			}

			if (std.getAddress().getPin_code() < 0) {
				throw new PinCodeCannotBeNegative();
			}
			if (deptsList.contains(std.getDepartmentId()))

			{
				try {
					studentrepo.save(std);
				} catch (Exception e) {
					System.out.println("Exception while adding students" + e);
				}
			} else {
				throw new DepartmentIdNotFound();
			}

		}
		try {
			studentrepo.saveAll(student);
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return student.size();

	}

	public Student getStudentById(int id) {
		return studentrepo.findById(id).get();

	}

	public int deleteStudentById(int id) {
		try {
			studentrepo.deleteById(id);
		} catch (Exception e) {
			System.out.println("This ID doesnot exist");
			throw new StudentNotFound();
		}
		return id;
	}

	private Student findStudentById(int id) {
		try {
			return studentrepo.findById(id).get();

		} catch (Exception e) {
//			System.out.println("Student Not Found");
			throw new StudentNotFound();
		}
			}

	private Book findBookById(int bookid) {
		try {
			return bookrepo.findById(bookid).get();
		} catch (Exception e) {
			System.out.println("Book Not Found");
			throw new BookNotFound();
		}
	}


	public Student updateStudentDetails(Student modifiedStudent) {
		try {
			Student student = findByStudentId(modifiedStudent.getId());
		} catch (Exception e) {
			throw new StudentNotFound();
		}
		List<Integer> deptsList = new ArrayList<>();
		try {
			deptsList = departmentimpl.getAll();
		} catch (Exception e) {
			System.out.println("Failed to fetch department List");
		}

		if (StringUtils.isBlank(modifiedStudent.getName())) {
			throw new StudentNameCannotBeNull();
		}

		if ((modifiedStudent.getBatch_year() < 0)) {
			throw new NoNegativeBatchYear();
		}
		if (deptsList.contains(modifiedStudent.getDepartmentId()))

		{
			try {
				studentrepo.save(modifiedStudent);
			} catch (Exception e) {
				System.out.println("Exception" + e);
			}
		} else {
			throw new DepartmentIdNotFound();
		}
		if(StringUtils.isBlank(modifiedStudent.getAddress().getStreet_name())) {
			throw new InvalidAddressDetails();
		}
		if(StringUtils.isBlank(modifiedStudent.getAddress().getAddressline_1())) {
			throw  new InvalidAddressDetails();
		}
		if(StringUtils.isBlank(modifiedStudent.getAddress().getAddressline_2())) {
			throw new InvalidAddressDetails();
		}
		if(StringUtils.isBlank(modifiedStudent.getAddress().getCity())) {
			throw new InvalidAddressDetails();
		}
		if(StringUtils.isBlank(modifiedStudent.getAddress().getCountry())){
			throw new InvalidAddressDetails();
		}
		if(modifiedStudent.getAddress().getPin_code() <0) {
			throw new PinCodeCannotBeNegative();
		}
		return modifiedStudent;
	}

	
	public Student findByStudentId(int id){
		try {
			return studentrepo.findById(id).get();
		} catch (Exception e){
			throw new StudentNotFound();
		}
}

	HashMap<Integer, Integer> myMap = new HashMap<>();

	public Student updateStudentBook(Integer stdid, Integer bookid) {
		Student student = findStudentById(stdid);
		Book book = findBookById(bookid);
		
		if (myMap.containsKey(bookid)) {
//			System.out.println(myMap.containsKey(bookid));
			throw new BookAlreadyTaken();  
		}
		myMap.put(bookid, stdid);
		student.setBook(book);
		try {
			studentrepo.save(student);
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return student;
	}

	int current_year = 2;

	public Student updateStudentYear(int id) {
		Student student = findStudentById(id);

		if (current_year > 3) {
			throw new GraduationCompleted();
		} else {
			student.setCurrent_year(current_year);
			current_year += 1;
			try {
				studentrepo.save(student);
			} catch (Exception e) {
				System.out.println("Exception" + e);
			} 
			return student;
		}
	}
}
