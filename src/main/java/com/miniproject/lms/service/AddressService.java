package com.miniproject.lms.service;

import com.miniproject.lms.model.Address;

public interface AddressService {
	
	//private Address findAddressById(int addressId);
	public Address updateStreet(int addressId, String streetname);
	public Address updateAddressline1(int addressId, String addressline1);
	public Address updateAddressline2(int addressId, String addressline2);
	public Address updateCity(int addressId, String city);
}
