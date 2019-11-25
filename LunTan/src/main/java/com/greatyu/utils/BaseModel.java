package com.greatyu.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

public class BaseModel {
    @ApiModelProperty("创建时间")
    Date bytime;
    @ApiModelProperty("是否删除0-删除，1-未删除")
    Integer isDelete;
    @ApiModelProperty("修改时间")
    Date  updatetime;
    @ApiModelProperty("当前第几页")
    private int pageNum;
    @ApiModelProperty("当前页大小")
    private int pageSize;

    public Date getBytime() {
        return bytime;
    }

    public void setBytime(Date bytime) {
        this.bytime = bytime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "bytime=" + bytime +
                ", isDelete=" + isDelete +
                ", updatetime=" + updatetime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
