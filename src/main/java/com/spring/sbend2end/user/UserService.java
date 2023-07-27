package com.spring.sbend2end.user;

import com.spring.sbend2end.registration.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    @Override
    public User registerUser(RegistrationRequest registration) {
        var user = new User(
                registration.getFirstName(),
                registration.getLastName(),
                registration.getEmail(),
                registration.getPassword(),
                Arrays.asList(new Role("ROLE_USER"))
        );
        return userRepository.save(user);
    }
}
