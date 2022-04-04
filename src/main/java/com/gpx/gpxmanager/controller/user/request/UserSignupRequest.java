package com.gpx.gpxmanager.controller.user.request;

import com.gpx.gpxmanager.service.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@Builder
public class UserSignupRequest {

    @NotBlank
    private String userName;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private LocalDate birthDate;

    private String street;
    private Integer number;
    private String city;

    @NotBlank (message = "country can't be blank")
    private String country;
    private String postCode;


    public User toUser() {
        return User.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .birthDate(birthDate)
                .street(street)
                .number(number)
                .city(city)
                .country(country)
                .postCode(postCode)
                .build();
    }

}
