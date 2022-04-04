package com.gpx.gpxmanager.exception.user;

import com.gpx.gpxmanager.exception.user.exception_class.CustomRuntimeException;
import com.gpx.gpxmanager.exception.user.exception_class.UserCreateException;
import com.gpx.gpxmanager.exception.user.exception_class.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {


    @ExceptionHandler(UserCreateException.class)
    public ResponseEntity<UserErrorMessage> userIsNotCreated(UserCreateException e){
        return new ResponseEntity<>(
          UserErrorMessage.userCreateErrorMessage(e), HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<UserErrorMessage> customRuntimeException(CustomRuntimeException e){
        return new ResponseEntity<>(
          UserErrorMessage.customRuntimeExceptionErrorMessage(e), HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserErrorMessage> userNotFound(UserNotFoundException e){
        return new ResponseEntity<>(
          UserErrorMessage.userNotFoundErrorMessage(e), HttpStatus.NOT_FOUND
        );
    }
}
