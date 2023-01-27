package com.miniproject.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionCtrl {
	@ExceptionHandler(value=DepartmentIdNotFound.class)
	public ResponseEntity<Object> exception(DepartmentIdNotFound exception){
		return new ResponseEntity<>("Department Id is Not valid",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=StudentNameCannotBeNull.class)
	public ResponseEntity<Object> exception1(StudentNameCannotBeNull exception){
		return new ResponseEntity<>("Name Cannot Be Null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NoNegativeBatchYear.class)
	public ResponseEntity<Object> exception2(NoNegativeBatchYear exception){
		return new ResponseEntity<>("Batch Year Cannot Be Negative",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= StudentNotFound.class)
	public ResponseEntity<Object> exception3(StudentNotFound exception){
		return new ResponseEntity<>("Student does not exist",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= BookNotFound.class)
	public ResponseEntity<Object> exception4(BookNotFound exception){
		return new ResponseEntity<>("Book does not exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookAlreadyTaken.class)
	public ResponseEntity<Object> exception5(BookAlreadyTaken exception){
		return new ResponseEntity<>("This Book Is Already Taken",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= GraduationCompleted.class)
	public ResponseEntity<Object> exception6(GraduationCompleted exception){
		return new ResponseEntity<>("Student Graduation Years Completed",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookNameCannotBeEmpty.class)
	public ResponseEntity<Object> exception7(BookNameCannotBeEmpty exception){
		return new ResponseEntity<>("Book name cannot be empty",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookAuthorCannotBeEmpty.class)
	public ResponseEntity<Object> exception8(BookAuthorCannotBeEmpty exception){
		return new ResponseEntity<>("Book Author name cannot be empty",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookTypeCannotBeEmpty.class)
	public ResponseEntity<Object> exception8(BookTypeCannotBeEmpty exception){
		return new ResponseEntity<>("Book Type cannot be empty or null",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= NoNegativeVersion.class)
	public ResponseEntity<Object> exception9(NoNegativeVersion exception){
		return new ResponseEntity<>("Book Version cannot be negative",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= NoNegativeReleaseYear.class)
	public ResponseEntity<Object> exception9(NoNegativeReleaseYear exception){
		return new ResponseEntity<>("Book Release Year cannot be negative",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= DateCannotBeNull.class)
	public ResponseEntity<Object> exception9(DateCannotBeNull exception){
		return new ResponseEntity<>("Date cannot be null or empty",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= AddressCannotBeEmpty.class)
	public ResponseEntity<Object> exception10(AddressCannotBeEmpty exception){
		return new ResponseEntity<>("Invalid address fields",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidAddressDetails.class)
	public ResponseEntity<Object> exception11(InvalidAddressDetails exception){
		return new ResponseEntity<>("Invalid address fields",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= PinCodeCannotBeNegative.class)
	public ResponseEntity<Object> exception12(PinCodeCannotBeNegative exception){
		return new ResponseEntity<>("Pincode Cannot Be Negative",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= StudentNameCannotBeEmpty.class)
	public ResponseEntity<Object> exception12(StudentNameCannotBeEmpty exception){
		return new ResponseEntity<>("Name Cannot Be Empty",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidAddressInput.class)
	public ResponseEntity<Object> exception12(InvalidAddressInput exception){
		return new ResponseEntity<>("Invalid Address Fields",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidAuthorName.class)
	public ResponseEntity<Object> exception13(InvalidAuthorName exception){
		return new ResponseEntity<>("Author name is not Valid \n Name must not begin with or contain special charatcters",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookNameCannotBeNull.class)
	public ResponseEntity<Object> exception13(BookNameCannotBeNull exception){
		return new ResponseEntity<>("Book name cannot be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= AuthorNameCannotBeEmpty.class)
	public ResponseEntity<Object> exception13(AuthorNameCannotBeEmpty exception){
		return new ResponseEntity<>("Author name cannot be empty",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BatchYearCannotBeNull.class)
	public ResponseEntity<Object> exception13(BatchYearCannotBeNull exception){
		return new ResponseEntity<>("Batch year cannot be null",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidName.class)
	public ResponseEntity<Object> exception13(InvalidName exception){
		return new ResponseEntity<>("Name is not Valid \n Name must not begin with or contain special characters",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= InvalidCountryName.class)
	public ResponseEntity<Object> exception13(InvalidCountryName exception){
		return new ResponseEntity<>("Name is not Valid \n Name must not begin with or contain special characters",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= AuthorNameCannotBeNull.class)
	public ResponseEntity<Object> exception14(AuthorNameCannotBeNull exception){
		return new ResponseEntity<>("Author name cannot be Null",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookTypeCannotBeNull.class)
	public ResponseEntity<Object> exception15(BookTypeCannotBeNull exception){
		return new ResponseEntity<>("Book type cannot be Null",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= DepartmentImplException.class)
	public ResponseEntity<Object> exception15(DepartmentImplException exception){
		return new ResponseEntity<>("Failed to fetch Departments",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= BookImplException.class)
	public ResponseEntity<Object> exception15(BookImplException exception){
		return new ResponseEntity<>("Failed to fetch Books",HttpStatus.NOT_FOUND);
	}
}	

