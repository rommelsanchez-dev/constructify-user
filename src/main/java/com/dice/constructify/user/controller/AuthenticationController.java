package com.dice.constructify.user.controller;

import com.dice.constructify.user.dto.BaseResponseDTO;
import com.dice.constructify.user.dto.LoginDTO;
import com.dice.constructify.user.exception.UserAuthenticationException;
import com.dice.constructify.user.service.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/constructify/user")
public class AuthenticationController {

    @Autowired
    private UserAuthentication userAuthentication;

    @PostMapping("/login")
    public BaseResponseDTO userLogin(@RequestBody LoginDTO loginDetails) {
        try {
            return BaseResponseDTO.builder().httpStatus(HttpStatus.OK).message(userAuthentication.userLogin(loginDetails)).build();
        } catch (UserAuthenticationException e) {
           return BaseResponseDTO.builder().httpStatus(HttpStatus.UNAUTHORIZED).message(e.getMessage()).build();
        }

    }

}

