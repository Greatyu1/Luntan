package com.greatyu.utils;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "基础Vo")
public class ResponseVo<T> {

    @ApiModelProperty(value = "数据")
    private T data;

    /**
     * 返回消息
     */
    @ApiModelProperty(value = "响应信息")
    private String responseMsg;

//    @ApiModelProperty(value = "返回码：正确0, 错误-1，其他错误为自定义码")
//    private int responseCode;
//    @ApiModelProperty(value = "返回消息")
//    private String responseMsg;

    /**
     * 代码
     */
    @ApiModelProperty(value = "响应码")
    private Integer responseCode;

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "成功标识")
    private boolean success;

    public ResponseVo() {
    }

    public ResponseVo(boolean success, Integer code, String msg) {
        this.responseMsg = msg;
        this.responseCode = code;
        this.success = success;
    }

//    public static <T> ResponseVo<T> buildSuccessInstance() {
//        return buildSuccessInstance(null);
//    }

    public static <T> ResponseVo<T> buildSuccessInstance(T data) {
        ResponseVo<T> responseVo = new ResponseVo<T>();
        responseVo.setData(data);
        responseVo.setResponseCode(200);
        responseVo.setResponseMsg("操作成功");
        responseVo.setSuccess(true);
        return responseVo;
    }

    public static <T> ResponseVo<T> buildFailInstance() {
        return new ResponseVo<T>(false, ErrorCode.COMMON_ERROR, "fail");
    }

    public static <T> ResponseVo<T> buildFailInstance(int errorCode, String msg) {
        return new ResponseVo<T>(false, errorCode, msg);
    }

   /* public static <T> ResponseVo<T> buildFailInstance(Exception ex) {

        if (ex instanceof HermesRuntimeException) {
            return new ResponseVo<T>(false, ((HermesRuntimeException) ex).getErrorCode(), ex.getMessage());
        } else if (ex instanceof HermesException) {
            return new ResponseVo<T>(false, ((HermesException) ex).getErrorCode(), ex.getMessage());
        }
        return new ResponseVo<T>(false, ErrorCode.COMMON_ERROR, ex.getMessage());
    }*/
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}