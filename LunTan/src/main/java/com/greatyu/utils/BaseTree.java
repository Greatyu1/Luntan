package com.greatyu.utils;

import com.greatyu.invitation.model.PingLun;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseTree<T> {
    @ApiModelProperty("节点名称")
    private String nodeName;
    @ApiModelProperty("唯一标识")
    private String nodeid;
    @ApiModelProperty("所有子节点信息")
    private List<T> childNodes;
    @ApiModelProperty("每一个节点对应的信息")
    public Object attribute;
}

