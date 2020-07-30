package com.secbro2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author sec
 * @version 1.0
 * @date 2020/7/23 11:03 上午
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MultipartException.class)
	public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
		return "redirect:/uploadStatus";
	}
}
