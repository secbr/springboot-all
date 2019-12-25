package com.secbro2.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/25 9:45 AM
 **/
@Component
public class Config {

	/**
	 * 工具
	 */
	@Value("car")
	private String tool;

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
}
