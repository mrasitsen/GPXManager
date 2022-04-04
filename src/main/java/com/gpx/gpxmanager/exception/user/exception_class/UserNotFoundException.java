package com.gpx.gpxmanager.exception.user.exception_class;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
