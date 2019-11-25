package com.greatyu.invitation.model;

import java.util.List;

public class BaseList{
    String id;
    String pingLunid;
    List<PingLun> ChilderList;
    PingLun ParentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPingLunid() {
        return pingLunid;
    }

    public void setPingLunid(String pingLunid) {
        this.pingLunid = pingLunid;
    }

    public List<PingLun> getChilderList() {
        return ChilderList;
    }

    public void setChilderList(List<PingLun> childerList) {
        ChilderList = childerList;
    }

    public PingLun getParentList() {
        return ParentList;
    }

    public void setParentList(PingLun parentList) {
        ParentList = parentList;
    }

    @Override
    public String toString() {
        return "BaseList{" +
                "id='" + id + '\'' +
                ", pingLunid='" + pingLunid + '\'' +
                ", ChilderList=" + ChilderList +
                ", ParentList=" + ParentList +
                '}';
    }
}

