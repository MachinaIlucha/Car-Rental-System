package com.illiapinchuk.carrentalsystem.exception.exceptionController;

import com.illiapinchuk.carrentalsystem.exception.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RoleExceptionController {

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<Object> roleNotFoundException() {
        return new ResponseEntity<>("There is no role with this id", HttpStatus.BAD_REQUEST);
    }
}
