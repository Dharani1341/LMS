package com.miniproject.lms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.lms.dao.AddressRepo;
import com.miniproject.lms.model.Address;
import com.miniproject.lms.service.AddressService;

@Service
public class AddressImpl implements AddressService {
	
	@Autowired
	AddressRepo addressrepo;

	private Address findAddressById(int addressId) {
		return addressrepo.findById(addressId).get();
	}
	
	
	public Address updateStreet(int addressId, String streetname) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setStreet_name(streetname);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
	}


	public Address updateAddressline1(int addressId, String addressline1) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setAddressline_1(addressline1);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
		
	}


	public Address updateAddressline2(int addressId, String addressline2) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setAddressline_2(addressline2);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
		
	}


	public Address updateCity(int addressId, String city) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setCity(city);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
		
	}


	public Address updateCountry(int addressId, String country) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setCountry(country);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
		
	}


	public Address updatePincode(int addressId, int pincode) {
		Address address = findAddressById(addressId);
		if(address.getAddressId() == addressId){
			address.setPin_code(pincode);
			try {
			addressrepo.save(address);
			}catch(Exception e) {
				System.out.println("Exception"+e);
			}
		}
		return address;
		
	}
	

}
