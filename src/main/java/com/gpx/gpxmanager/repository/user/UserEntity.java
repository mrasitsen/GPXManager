package com.gpx.gpxmanager.repository.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserTable")
@Table(name = "UserTable")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
