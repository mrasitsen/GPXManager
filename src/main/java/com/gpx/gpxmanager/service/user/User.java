package com.gpx.gpxmanager.service.user;

import com.gpx.gpxmanager.repository.user.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String street;
    private Integer number;
    private String city;
    private String country;
    private String postCode;


    public UserEntity toUserEntity() {
        return UserEntity.builder()
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

    public static User toUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .userName(userEntity.getUserName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .birthDate(userEntity.getBirthDate())
                .street(userEntity.getStreet())
                .number(userEntity.getNumber())
                .city(userEntity.getCity())
                .country(userEntity.getCountry())
                .postCode(userEntity.getPostCode())
                .build();
    }
}
