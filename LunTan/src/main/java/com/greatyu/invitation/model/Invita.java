package com.greatyu.invitation.model;

import com.greatyu.utils.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

public class Invita extends BaseModel {
    @ApiModelProperty("用户编码")
    String userCode;
    @ApiModelProperty("帖子id")
    String inviteId;
    @ApiModelProperty("帖子标题")
    String inviteTitle;
    @ApiModelProperty("帖子内容")
    String inviteContent;
    @ApiModelProperty("分类")
    String type;
    @ApiModelProperty("帖子编码")
    String inviteCode;
    @ApiModelProperty("头像")
    String ImgUrl;
    @ApiModelProperty("访问人数")
    Integer num;
    @ApiModelProperty("评论人数")
    Integer pinglunNum;

    public Integer getPinglunNum() {
        return pinglunNum;
    }

    public void setPinglunNum(Integer pinglunNum) {
        this.pinglunNum = pinglunNum;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId;
    }

    public String getInviteTitle() {
        return inviteTitle;
    }

    public void setInviteTitle(String inviteTitle) {
        this.inviteTitle = inviteTitle;
    }

    public String getInviteContent() {
        return inviteContent;
    }

    public void setInviteContent(String inviteContent) {
        this.inviteContent = inviteContent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Invita{" +
                "userCode='" + userCode + '\'' +
                ", inviteId='" + inviteId + '\'' +
                ", inviteTitle='" + inviteTitle + '\'' +
                ", inviteContent='" + inviteContent + '\'' +
                ", type='" + type + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", ImgUrl='" + ImgUrl + '\'' +
                ", num=" + num +
                ", pinglunNum=" + pinglunNum +
                '}';
    }
}
