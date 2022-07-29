package com.illiapinchuk.carrentalsystem.exception.exceptionController;

import com.illiapinchuk.carrentalsystem.exception.BookingUnavailableCarException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptionController {

    @ExceptionHandler(value = BookingUnavailableCarException.class)
    public ResponseEntity<Object> bookingUnavailableCarException() {
        return new ResponseEntity<>("This car already booked", HttpStatus.BAD_REQUEST);
    }
}
