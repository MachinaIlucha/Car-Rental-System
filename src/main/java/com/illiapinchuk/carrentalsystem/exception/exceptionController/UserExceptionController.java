package com.illiapinchuk.carrentalsystem.exception.exceptionController;

import com.illiapinchuk.carrentalsystem.exception.EmailExistsException;
import com.illiapinchuk.carrentalsystem.exception.LoginExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(value = EmailExistsException.class)
    public ResponseEntity<Object> emailExistsException() {
        return new ResponseEntity<>("There is an account with that email address", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = LoginExistsException.class)
    public ResponseEntity<Object> loginExistsException() {
        return new ResponseEntity<>("There is an account with that login: ", HttpStatus.BAD_REQUEST);
    }
}
