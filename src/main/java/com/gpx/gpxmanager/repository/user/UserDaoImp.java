package com.gpx.gpxmanager.repository.user;

import com.gpx.gpxmanager.exception.user.exception_class.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDaoImp implements UserDao {

    private final UserJPARepository userJPARepository;

    @Override
    public UserEntity signupUser(UserEntity userEntity) {
        UserEntity createdUserEntity = userJPARepository.save(userEntity);
        return createdUserEntity;
    }

    @Override
    public UserEntity retrieveUser(Long id) {
        Optional<UserEntity> retrievedUserEntity = userJPARepository.findById(id);

        if(retrievedUserEntity.isEmpty()){
            throw new UserNotFoundException("There is no user with id: "+id);
        }

        return retrievedUserEntity.get();

    }
}
