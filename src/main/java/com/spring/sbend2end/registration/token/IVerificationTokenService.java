package com.spring.sbend2end.registration.token;

import com.spring.sbend2end.user.User;

import java.util.Optional;

public interface IVerificationTokenService {

    String validateToken(String token);
    void saveVerificationTokenForUser(User user, String token);
    Optional<VerificationToken> findByToken(String token);
}
