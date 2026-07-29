package com.irctc.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irctc.exception.BookingNotFoundException;
import com.irctc.exception.InvalidPasswordException;
import com.irctc.exception.PassengerNotFoundException;
import com.irctc.exception.TrainNotFoundException;
import com.irctc.exception.UserNotFoundException;

@RestControllerAdvice
public class MyAppExcptionHandller {
	
	 @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String> handleUserNotFound(UserNotFoundException user) {
	        return new ResponseEntity<>(user.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(InvalidPasswordException.class)
	    public ResponseEntity<String> invalidPasswordException(InvalidPasswordException invalid) {
	        return new ResponseEntity<>(invalid.getMessage(), HttpStatus.NOT_FOUND);
	    }

	 @ExceptionHandler(TrainNotFoundException.class)
	    public ResponseEntity<String> trainNotFoundException(TrainNotFoundException train) {
	        return new ResponseEntity<>(train.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(PassengerNotFoundException.class)
	    public ResponseEntity<String> passengerNotFoundException(TrainNotFoundException train) {
	        return new ResponseEntity<>(train.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 
//BookingNotFoundException
	 
	 @ExceptionHandler(BookingNotFoundException.class)
	    public ResponseEntity<String> bookingNotFoundException(BookingNotFoundException train) {
	        return new ResponseEntity<>(train.getMessage(), HttpStatus.NOT_FOUND);
	    }
	

	 
}
