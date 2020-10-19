package com.egg.settings.service;

import com.egg.exception.LoginException;
import com.egg.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
