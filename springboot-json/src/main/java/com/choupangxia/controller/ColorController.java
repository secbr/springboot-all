package com.choupangxia.controller;

import com.choupangxia.entity.ColorDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/31 10:10 AM
 **/
@RestController
@RequestMapping("/color")
public class ColorController {

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping(value = "getColor")
	public ColorDetail getColor() {

		ColorDetail colorDetail = new ColorDetail();
		colorDetail.setRed(0.94D);
		colorDetail.setGreen(0.97D);
		colorDetail.setBlue(1.0D);

		return colorDetail;
	}

	@PostMapping("/postColor")
	public void postColor(String webColor) throws JsonProcessingException {

		ColorDetail detail = objectMapper.readValue(webColor, ColorDetail.class);

		System.out.println("red:" + detail.getRed());
		System.out.println("green:" + detail.getGreen());
		System.out.println("blue:" + detail.getBlue());
	}

}
