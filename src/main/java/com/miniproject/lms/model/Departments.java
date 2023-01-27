package com.miniproject.lms.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Departments {
	@Id
	private int deptid;

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
    public Departments(int deptid) {
    	super();
    	this.deptid = deptid;
    }
    public Departments() {

	}
}
