package com.dice.constructify.user.service.impl;

import com.dice.constructify.user.exception.UserRegistrationException;
import com.dice.constructify.user.repository.UserRepository;
import com.dice.constructify.user.dto.UserDTO;
import com.dice.constructify.user.entity.User;
import com.dice.constructify.user.service.UserRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserRegistrationServiceImpl implements UserRegistration {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserDTO userDTO) throws UserRegistrationException {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new UserRegistrationException("Email is already registered.");
        }

        passwordEncoder = new BCryptPasswordEncoder();
        LocalDateTime now = LocalDateTime.now();

        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreate_dttm(now);
        user.setUpdate_dttm(now);
        user.setStatus(userDTO.getStatus());

        userRepository.save(user);

        return userRepository.findOneByEmail(userDTO.getEmail());
    }
}
