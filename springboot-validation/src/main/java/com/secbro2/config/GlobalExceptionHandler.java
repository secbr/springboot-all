package com.secbro2.config;

import com.secbro2.util.BizResult;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/9 9:26 AM
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 针对方法中的参数校验，拦截数据校验异常
	 *
	 * @param ex 校验异常
	 * @return 通用返回格式
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public BizResult notValidException(ConstraintViolationException ex) {
		BizResult result = new BizResult();
		result.setCode("500");

		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		if (!CollectionUtils.isEmpty(constraintViolations)) {
			StringBuilder sb = new StringBuilder();
			for (ConstraintViolation constraintViolation : constraintViolations) {
				sb.append(constraintViolation.getMessage()).append(",");
			}
			String errorMessage = sb.toString();
			if (errorMessage.length() > 1) {
				errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
			}
			result.setErrorMsg(errorMessage);
			return result;
		}

		result.setErrorMsg(ex.getMessage());

		return result;
	}

	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public BizResult resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		BizResult result = new BizResult();
		result.setCode("500");

		List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
		if(!CollectionUtils.isEmpty(objectErrors)) {
			StringBuilder msgBuilder = new StringBuilder();
			for (ObjectError objectError : objectErrors) {
				msgBuilder.append(objectError.getDefaultMessage()).append(",");
			}
			String errorMessage = msgBuilder.toString();
			if (errorMessage.length() > 1) {
				errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
			}
			result.setErrorMsg(errorMessage);
			return result;
		}

		result.setErrorMsg(ex.getMessage());
		return result;
	}*/

	/**
	 * 针对对象绑定统一异常处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public BizResult resolveMethodArgumentNotValidException(BindException ex) {
		BizResult result = new BizResult();
		result.setCode("500");

		List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
		if (!CollectionUtils.isEmpty(objectErrors)) {
			StringBuilder msgBuilder = new StringBuilder();
			for (ObjectError objectError : objectErrors) {
				msgBuilder.append(objectError.getDefaultMessage()).append(",");
			}
			String errorMessage = msgBuilder.toString();
			if (errorMessage.length() > 1) {
				errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
			}
			result.setErrorMsg(errorMessage);
			return result;
		}

		result.setErrorMsg(ex.getMessage());
		return result;
	}
}
