package com.gpx.gpxmanager.controller.user.respose;

import com.gpx.gpxmanager.service.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserProfileResponse {

    private Long id;
    private String userName;
    private String email;
    private LocalDate birthDate;
    private String street;
    private Integer number;
    private String city;
    private String country;
    private String postCode;

    public static UserProfileResponse response(User user){
        return UserProfileResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .street(user.getStreet())
                .number(user.getNumber())
                .city(user.getCity())
                .country(user.getCountry())
                .postCode(user.getPostCode())
                .build();
    }
}
