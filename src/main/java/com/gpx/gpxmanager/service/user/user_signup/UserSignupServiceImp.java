package com.gpx.gpxmanager.service.user.user_signup;

import com.gpx.gpxmanager.repository.user.UserEntity;
import com.gpx.gpxmanager.repository.user.UserDao;
import com.gpx.gpxmanager.service.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupServiceImp implements UserSignupService {

    private final UserDao userSignupDao;

    @Override
    public User signup(User user) {
        UserEntity userEntity = user.toUserEntity();
        UserEntity createdUserEntity = userSignupDao.signupUser(userEntity);
        User createdUser = User.toUser(createdUserEntity);
        return createdUser;
    }
}
