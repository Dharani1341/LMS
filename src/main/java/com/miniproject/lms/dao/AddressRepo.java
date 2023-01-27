package com.miniproject.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.lms.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
