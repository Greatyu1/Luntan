package com.greatyu.users.controller;


import com.greatyu.users.model.User;
import com.greatyu.users.service.UserService;
import com.greatyu.utils.ResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private ResponseVo responseVo;

    @PostMapping("/list")
    @ApiOperation(value = "查询用户列表")
    @ResponseBody
    private ResponseVo listUser(@RequestBody User user){
       try{
           responseVo =userService.listUser(user);
       }catch (Exception e){
           e.printStackTrace();
           responseVo=ResponseVo.buildFailInstance(500,"服务器错误");
       }
       return responseVo;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    @ResponseBody
    private ResponseVo login(@RequestBody String body){
        try{

            responseVo =userService.login(body);
        }catch (Exception e){
            e.printStackTrace();
            responseVo=ResponseVo.buildFailInstance(500,"服务器错误");
        }
        return responseVo;
    }
}
