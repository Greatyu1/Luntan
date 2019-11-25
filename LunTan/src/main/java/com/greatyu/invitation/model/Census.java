package com.greatyu.invitation.model;

public class Census {
    String id;
    String invite_code;
    String userId;
    String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Census{" +
                "id='" + id + '\'' +
                ", invite_code='" + invite_code + '\'' +
                ", userId='" + userId + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
