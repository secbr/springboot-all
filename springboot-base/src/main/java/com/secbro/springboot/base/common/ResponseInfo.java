package com.secbro.springboot.base.common;

import com.secbro.springboot.base.enums.ResponseCodeEnums;
import lombok.Data;

/**
 * 统一返回结果实体类
 *
 * @author sec
 * @version 1.0
 * @date 2022/8/1
 **/
@Data
public class ResponseInfo<T> {

	/**
	 * 状态码
	 */
	protected int code;

	/**
	 * 响应信息
	 */
	protected String message;

	/**
	 * 返回数据
	 */
	private T data;

	public static <T> ResponseInfo<T> success() {
		return new ResponseInfo<>();
	}

	public static <T> ResponseInfo<T> success(T data) {
		return new ResponseInfo<>(data);
	}

	public static <T> ResponseInfo<T> fail(String message) {
		return new ResponseInfo<>(ResponseCodeEnums.FAIL.getCode(), message);
	}

	public ResponseInfo() {
		this.code = ResponseCodeEnums.SUCCESS.getCode();
		this.message = ResponseCodeEnums.SUCCESS.getMessage();
	}

	public ResponseInfo(ResponseCodeEnums statusEnums) {
		this.code = statusEnums.getCode();
		this.message = statusEnums.getMessage();
	}

	/**
	 * 若没有数据返回，可以人为指定状态码和提示信息
	 */
	public ResponseInfo(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	/**
	 * 有数据返回时，状态码为200，默认提示信息为“操作成功！”
	 */
	public ResponseInfo(T data) {
		this.data = data;
		this.code = ResponseCodeEnums.SUCCESS.getCode();
		this.message = ResponseCodeEnums.SUCCESS.getMessage();
	}

	/**
	 * 有数据返回，状态码为 200，人为指定提示信息
	 */
	public ResponseInfo(T data, String msg) {
		this.data = data;
		this.code = ResponseCodeEnums.SUCCESS.getCode();
		this.message = msg;
	}
}
