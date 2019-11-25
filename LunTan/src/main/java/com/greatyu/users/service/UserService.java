package com.greatyu.users.service;

import com.greatyu.users.model.User;
import com.greatyu.utils.ResponseVo;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface UserService {
    ResponseVo listUser(User user);

    ResponseVo login(String body) throws JSONException;
}
