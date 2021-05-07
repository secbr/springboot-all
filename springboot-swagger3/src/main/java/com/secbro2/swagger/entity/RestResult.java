package com.secbro2.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sec
 * @version 1.0
 * @date 2021/5/7
 **/
@ApiModel("API通用数据")
public class RestResult<T> {

    /**
     * 标识代码，0表示成功，非0表示出错
     */
    @ApiModelProperty("标识代码,0表示成功，非0表示出错")
    private Integer code;

    /**
     * 描述信息，通常供报错时使用
     */
    @ApiModelProperty("描述信息,供报错时使用")
    private String msg;

    /**
     * 业务数据
     */
    @ApiModelProperty("业务数据")
    private T data;

    public RestResult() {
    }

    public RestResult(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     */
    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(0, "成功", data);
    }

    public static <T> RestResult<T> success(Integer code, String msg) {
        return new RestResult<>(code, msg, null);
    }

    /**
     * 错误
     */
    public static <T> RestResult<T> error(int code, String msg) {
        return new RestResult<>(code, msg, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
