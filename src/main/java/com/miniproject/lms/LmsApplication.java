package com.miniproject.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.miniproject.lms.serviceImpl.StudentImpl;

@SpringBootApplication
public class LmsApplication {

	@Bean
	public StudentImpl studentImpl()
	{
		return new StudentImpl();
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(LmsApplication.class, args);
	}
}
