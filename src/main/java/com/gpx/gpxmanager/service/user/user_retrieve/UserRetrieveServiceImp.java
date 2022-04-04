package com.gpx.gpxmanager.service.user.user_retrieve;

import com.gpx.gpxmanager.repository.user.UserDao;
import com.gpx.gpxmanager.repository.user.UserEntity;
import com.gpx.gpxmanager.service.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRetrieveServiceImp implements UserRetrieveService {

    private final UserDao userDao;

    @Override
    public User retrieveUser(Long id) {
        UserEntity retrievedUserEntity = userDao.retrieveUser(id);
        User retrievedUser = User.toUser(retrievedUserEntity);
        return retrievedUser;
    }
}
