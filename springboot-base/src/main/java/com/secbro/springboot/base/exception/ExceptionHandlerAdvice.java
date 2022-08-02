package com.secbro.springboot.base.exception;

import com.secbro.springboot.base.common.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @author sec
 * @version 1.0
 * @date 2022/8/2
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * 参数格式异常处理
	 */
	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseInfo<String> badRequestException(IllegalArgumentException ex) {
		log.error("参数格式不合法：{}", ex.getMessage());
		return new ResponseInfo<>(HttpStatus.BAD_REQUEST.value() + "", "参数格式不符！");
	}

	/**
	 * 权限不足异常处理
	 */
	@ExceptionHandler({AccessDeniedException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseInfo<String> badRequestException(AccessDeniedException ex) {
		return new ResponseInfo<>(HttpStatus.FORBIDDEN.value() + "", ex.getMessage());
	}

	/**
	 * 参数缺失异常处理
	 */
	@ExceptionHandler({MissingServletRequestParameterException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseInfo<String> badRequestException(Exception ex) {
		return new ResponseInfo<>(HttpStatus.BAD_REQUEST.value() + "", "缺少必填参数！");
	}

	/**
	 * 空指针异常
	 */
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseInfo<String> handleTypeMismatchException(NullPointerException ex) {
		log.error("空指针异常，{}", ex.getMessage());
		return ResponseInfo.fail("空指针异常");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseInfo<String> handleUnexpectedServer(Exception ex) {
		log.error("系统异常：", ex);
		return ResponseInfo.fail("系统发生异常，请联系管理员");
	}

	/**
	 * 系统异常处理
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseInfo<String> exception(Throwable throwable) {
		log.error("系统异常", throwable);
		return new ResponseInfo<>(HttpStatus.INTERNAL_SERVER_ERROR.value() + "系统异常，请联系管理员！");
	}
}
