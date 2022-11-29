package com.dice.constructify.user.service;

import com.dice.constructify.user.dto.LoginDTO;
import com.dice.constructify.user.exception.UserAuthenticationException;

public interface UserAuthentication {

    public String userLogin(LoginDTO loginDetails) throws UserAuthenticationException;
}
