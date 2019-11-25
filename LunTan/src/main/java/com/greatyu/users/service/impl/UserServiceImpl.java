package com.greatyu.users.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greatyu.users.mapper.UserMapper;
import com.greatyu.users.model.User;
import com.greatyu.users.service.UserService;
import com.greatyu.utils.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    private ResponseVo responseVo;

    /**
     * 查询用户
     * @param user
     * @return
     */
    @Override
    public ResponseVo listUser(User user) {
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> list=userMapper.listUser(user);
        PageInfo pageInfo=new PageInfo(list);
        responseVo=ResponseVo.buildSuccessInstance(pageInfo);
        return responseVo;
    }

    /**
     * 登陆
     * @param body
     * @return
     */
    @Override
    public ResponseVo login(String body) throws JSONException {
        JSONObject jsonObject=new JSONObject(body);
        String username=jsonObject.getString("username");
        String password=jsonObject.getString("password");
        System.out.println(username+"===="+password);
        User user=userMapper.login(username,password);
        if (user==null){
            return ResponseVo.buildFailInstance();
        }
        return ResponseVo.buildSuccessInstance(user);
    }
}
