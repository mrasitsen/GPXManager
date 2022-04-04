package com.gpx.gpxmanager.exception.user;

import com.gpx.gpxmanager.exception.user.exception_class.CustomRuntimeException;
import com.gpx.gpxmanager.exception.user.exception_class.UserCreateException;
import com.gpx.gpxmanager.exception.user.exception_class.UserNotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserErrorMessage {

    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
    private String message;

    public static UserErrorMessage userCreateErrorMessage(UserCreateException e){
        return UserErrorMessage.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static UserErrorMessage customRuntimeExceptionErrorMessage(CustomRuntimeException e){
        return UserErrorMessage.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static UserErrorMessage userNotFoundErrorMessage(UserNotFoundException e){
        return UserErrorMessage.builder()
                .message(e.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
