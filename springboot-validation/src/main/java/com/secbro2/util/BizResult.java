package com.secbro2.util;

import lombok.Data;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/9 9:27 AM
 **/
@Data
public class BizResult {

	private String code = "200";

	private String errorMsg;

	private String data;
}
