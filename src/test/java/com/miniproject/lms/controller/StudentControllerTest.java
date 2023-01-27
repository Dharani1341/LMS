package com.miniproject.lms.controller;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.miniproject.lms.model.Address;
import com.miniproject.lms.model.Student;
import com.miniproject.lms.serviceImpl.StudentImpl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

	private final static String BASE_URI = "http://localhost";

	private final ObjectMapper objectMapper = new ObjectMapper();

	ObjectWriter objectWriter = objectMapper.writer();

	@MockBean
	private StudentImpl studentImpl;

	@LocalServerPort
	private int port;
	Student s1 = new Student();
	Student s2 = new Student();
	
	
	Address address1 = new Address(1, "Street", "address_line1", "address_line2", "city", "country", 123456);
	Address address2 = new Address(1, "Street", "address_line1", "address_line2", "city", "country", 123456);

	@BeforeEach
	public void init() {
		s1.setId(2052);
		s1.setName("Dharani");
		s1.setBatch_year(2001);
		s1.setDepartmentId(101);
		s1.setAddress(address1);
		s1.setCurrent_year(1);

		//s2.setId(1);
		s2.setName("Dharan");
		s2.setBatch_year(2001);
		s2.setDepartmentId(101);
		s2.setAddress(address2);
		s2.setCurrent_year(1);
	}

	@BeforeEach
	public void setUp() {
		baseURI = BASE_URI;
		port = this.port;
	}

	@Test
	@DisplayName("Test to get all Students")
	public void testGet() {
      given()
      .contentType(ContentType.JSON)
      .get("/students/getStudentDetails")
      .then().assertThat()
      .statusCode(200);	
	}

	@Test
	public void testStudentById() {
		given()
		.contentType(ContentType.JSON)
		.get("/students/studentById/2052")
		.then()
		.assertThat()
		.statusCode(200);
	}

	@Test
	public void testUpdateStudent() throws Exception {
		
		String content = objectWriter.writeValueAsString(s1);  
	
		given()
		.contentType(ContentType.JSON)
		.body(content)
		.put("/students/updateStudentDetails")
        .then()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 ")
        .body("address.pin_code", equalTo( 123456));
	}

	@Test
	public void testAddStudent() throws Exception {
		String content = objectWriter.writeValueAsString(List.of(s2));
		
		given()
		.contentType(ContentType.JSON)
		.body(content)
		.post("/students/addStudents")
		.then()
		.statusCode(200);
//		.statusLine("HTTP/1.1 200 ")
//		.assertThat()
//		.body("",Matchers.equalTo("Number Of Students Added is : 1"));
		
				
	}

	@Test
	public void testDelete() {
		given()
		.baseUri("http://localhost/students/deleteStudentById/2004") //book getting deleted in repo
		.contentType(ContentType.JSON)
		.when()
		.delete()
		.then()
		.assertThat()
		.statusCode(200);
	}

}
