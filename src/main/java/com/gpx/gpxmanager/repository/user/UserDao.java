package com.gpx.gpxmanager.repository.user;

public interface UserDao {
    UserEntity signupUser(UserEntity userEntity);

    UserEntity retrieveUser(Long id);
}
