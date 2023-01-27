package com.miniproject.lms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.lms.dao.DepartmentRepository;
import com.miniproject.lms.model.Book;
import com.miniproject.lms.model.Departments;
import com.miniproject.lms.service.DepartmentService;

@Service
public class DepartmentsImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentrepo;


	public List<Integer> getAll() {
		List<Integer> deptList = new ArrayList<>();
		deptList.add(101);
		deptList.add(102);
		deptList.add(103);
		deptList.add(104);
		deptList.add(105);
		System.out.println("Here");
		return deptList;
	}

	public void deletedepts(int deptid) {
		departmentrepo.deleteById(deptid);
	}

}
