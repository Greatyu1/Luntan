package com.greatyu.invitation.model;

import com.greatyu.utils.BaseModel;

public class PingLun extends BaseModel {
    String inviteCode;
    String commentId;
    String replyId;
    String commentText;
    String commentCode;
    String imgUrl;
    String userName;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "PingLun{" +
                "inviteCode='" + inviteCode + '\'' +
                ", commentId='" + commentId + '\'' +
                ", replyId='" + replyId + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentCode='" + commentCode + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
