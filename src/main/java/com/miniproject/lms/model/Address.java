package com.miniproject.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "add_id")
	private Integer addressId;
	private String street_name;
	private String addressline_1;
	private String addressline_2;
	private String city;
	private String country;
	private int pin_code;

	Address(){
		
	}
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getAddressline_1() {
		return addressline_1;
	}

	public void setAddressline_1(String addressline_1) {
		this.addressline_1 = addressline_1;
	}

	public String getAddressline_2() {
		return addressline_2;
	}

	public void setAddressline_2(String addressline_2) {
		this.addressline_2 = addressline_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public Address(int addressId, String street_name, String addressline_1, String addressline_2, String city,
			String country, int pin_code) {
		super();
		this.addressId = addressId;
		this.street_name = street_name;
		this.addressline_1 = addressline_1;
		this.addressline_2 = addressline_2;
		this.city = city;
		this.country = country;
		this.pin_code = pin_code;
	}

}
