package com.gpx.gpxmanager.controller.user;

import com.gpx.gpxmanager.controller.user.respose.UserProfileResponse;
import com.gpx.gpxmanager.service.user.User;
import com.gpx.gpxmanager.controller.user.request.UserSignupRequest;
import com.gpx.gpxmanager.controller.user.respose.UserSignupResponse;
import com.gpx.gpxmanager.service.user.user_retrieve.UserRetrieveService;
import com.gpx.gpxmanager.service.user.user_signup.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;
    private final UserRetrieveService userRetrieveService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserSignupResponse> signupUser(@Valid @RequestBody UserSignupRequest userSignupRequest){
            User user = userSignupRequest.toUser();
            User createdUser = userSignupService.signup(user);
            UserSignupResponse userSignupResponse = UserSignupResponse.response(createdUser);
            return new ResponseEntity<>(userSignupResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/profile")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserProfileResponse> retrieveUser(@PathVariable Long id){
        User retrievedUser = userRetrieveService.retrieveUser(id);
        UserProfileResponse userProfileResponse = UserProfileResponse.response(retrievedUser);
        return new ResponseEntity<>(userProfileResponse, HttpStatus.OK);
    }
}
