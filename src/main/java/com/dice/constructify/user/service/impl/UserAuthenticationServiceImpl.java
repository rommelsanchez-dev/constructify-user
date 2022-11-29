package com.dice.constructify.user.service.impl;

import com.dice.constructify.user.dto.LoginDTO;
import com.dice.constructify.user.exception.UserAuthenticationException;
import com.dice.constructify.user.repository.UserRepository;
import com.dice.constructify.user.service.UserAuthentication;
import com.dice.constructify.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAuthenticationServiceImpl implements UserAuthentication {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public String userLogin(LoginDTO loginDetails) throws UserAuthenticationException {

        String message = "Login Successful.";
        String invalidCredentialsMessage = "Invalid Email or Password";

        if (!userRepository.existsByEmail(loginDetails.getEmail())) {
            throw new UserAuthenticationException(invalidCredentialsMessage);
        }

        User user = userRepository.findOneByEmail(loginDetails.getEmail());
        passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(loginDetails.getPassword(), user.getPassword())) {
            return message;
        } else {
            throw new UserAuthenticationException(invalidCredentialsMessage);
        }

    }
}
