package com.egg.crm.settings.service;

import com.egg.crm.exception.LoginException;
import com.egg.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
