package com.dice.constructify.user.controller;

import com.dice.constructify.user.dto.BaseResponseDTO;
import com.dice.constructify.user.entity.User;
import com.dice.constructify.user.exception.UserRegistrationException;
import com.dice.constructify.user.service.UserRegistration;
import com.dice.constructify.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/constructify/user")
public class RegistrationController {

    @Autowired
    private UserRegistration userRegistration;

    @PostMapping("/register")
    public BaseResponseDTO registerUser(@RequestBody UserDTO userDTO) throws UserRegistrationException {
        try {
            return BaseResponseDTO.<User>builder().httpStatus(HttpStatus.CREATED).data(userRegistration.registerUser(userDTO)).build();
        } catch (UserRegistrationException e) {
            return BaseResponseDTO.builder().httpStatus(HttpStatus.BAD_REQUEST).message(e.getMessage()).build();
        }

    }
}
