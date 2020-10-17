package com.egg.crm.settings.service;

import com.egg.crm.exception.LoginException;
import com.egg.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
