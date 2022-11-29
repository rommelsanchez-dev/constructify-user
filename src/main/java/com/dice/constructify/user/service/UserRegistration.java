package com.dice.constructify.user.service;

import com.dice.constructify.user.exception.UserRegistrationException;
import com.dice.constructify.user.dto.UserDTO;
import com.dice.constructify.user.entity.User;


public interface UserRegistration {

    public User registerUser(UserDTO userDTO) throws UserRegistrationException;

}
