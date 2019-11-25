package com.greatyu.users.model;


import com.greatyu.utils.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User extends BaseModel {
    @ApiModelProperty("用户编码")
    String userCode;
    @ApiModelProperty("用户姓名")
    String userName;
    @ApiModelProperty("用户密码")
    String userPwd;
    @ApiModelProperty("用户性别")
    Integer userSex;
    @ApiModelProperty("邮箱地址")
    String email;
    @ApiModelProperty("电话号码")
    String phone;
    @ApiModelProperty("积分")
    float score;
    @ApiModelProperty("格言")
    String geyan;
    @ApiModelProperty("qq")
    String qq;
    @ApiModelProperty("用户头像")
    String userUrl;
    @ApiModelProperty("身份0-管理员，1-用户")
    Integer admin;

}
