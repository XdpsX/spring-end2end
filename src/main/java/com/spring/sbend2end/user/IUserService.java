package com.spring.sbend2end.user;

import com.spring.sbend2end.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAllUsers();
    User findByEmail(String email);
    User registerUser(RegistrationRequest registration);
}
