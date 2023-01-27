package com.miniproject.lms.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miniproject.lms.dao.AddressRepo;
import com.miniproject.lms.dao.BookRepo;
import com.miniproject.lms.dao.DepartmentRepository;
import com.miniproject.lms.dao.StudentRepository;
import com.miniproject.lms.model.Address;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Departments;
import com.miniproject.lms.model.Student;

@ExtendWith(MockitoExtension.class)
class StudentImplTest {

	@InjectMocks
	StudentImpl studentImpl;
	
	@Mock
	AddressRepo addressRepo;
	
	@Mock 
	DepartmentRepository departmentRepository;
	
	@Mock
	StudentRepository studentRepository;
	
	@Mock
	BookRepo bookRePo;
	
	@Mock
	DepartmentsImpl departmentsImpl;
	
	Student student;
	Departments departments;
//  Long addressId, String street_name, String addressline_1, String addressline_2, String city,
//	String country, int pin_code)
	
	Address address = new Address(1,"TestStreet","Test","Test","Hyderabad","India",1010);
	//int bookId, String name, String author, double version, int release_year, String book_type)
	Book book = new Book(1,"Java","James",2.0d,2001,"Subject");
	
    @BeforeEach
    void init() {
    	student = new Student();
    	
    	student.setId(1);
    	student.setName("Rajeswari");
    	student.setCurrent_year(1);
    	student.setBatch_year(2002);
    	student.setDepartmentId(103);
        student.setAddress(address);

    }
    
	

	
	@Test
	@DisplayName("Test for Getting Added Students")
	void testGetStudents() {
		List<Student> studentList = new ArrayList<>();
		Mockito.when(studentRepository.findAll()).thenReturn(studentList);
		assertEquals(studentList,studentImpl.getAll());
	}

	
	@Test
	@DisplayName("Test for Saving Students")
	void testAddStudents(){
		List<Student> studentList = new ArrayList<>();
		List<Integer> deptList = new ArrayList<>();
		deptList.add(103);
		studentList.add(student);
		Mockito.when(departmentsImpl.getAll()).thenReturn(deptList);
		Mockito.when(studentRepository.saveAll(studentList)).thenReturn(studentList);
		assertEquals(1,studentImpl.addAll(studentList));
	}
	
	@Test
	@DisplayName("Test for GetStudentById")
	void testGetStudentById() throws Exception{
		
		Optional<Student> studentOp = Optional.of(student);
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(studentOp );
		assertEquals(student,studentImpl.getStudentById(student.getId()));
	}
    
	@Test
	@DisplayName("Test For DeleteStudentById")
	void testDeleteStudentById(){
		studentImpl.deleteStudentById(student.getId());
		verify(studentRepository,times(1)).deleteById(student.getId());
	}
	
	@Test
	@DisplayName("Test for updating student")
	void testUpdateStudent() {
		Optional<Student> studentOp = Optional.of(student);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(103);
		
  		Mockito.when(departmentsImpl.getAll()).thenReturn(arr);
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(studentOp);
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student,studentImpl.updateStudentDetails(student));
	}
	

	@Test
	@DisplayName("Test for Enrolling Book To Student")
	void testEnrol() {

		Optional<Student> studentOp = Optional.of(student);
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(studentOp);
		
		Optional<Book> bookOp = Optional.of(book);
		
		Mockito.when(bookRePo.findById(book.getBookId())).thenReturn(bookOp);
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		
		assertEquals(student,studentImpl.updateStudentBook(student.getId(),book.getBookId()));
	}
	
	@Test
	@DisplayName("Test for Upgradinting student BatchYear")
	void testUpgrade() {
		
       Optional<Student> studentOp = Optional.of(student);
		
		Mockito.when(studentRepository.findById(student.getId())).thenReturn(studentOp);
		
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		
		assertEquals(student,studentImpl.updateStudentYear(student.getId()));
}}

