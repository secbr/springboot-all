package com.secbro2.util;

import java.util.UUID;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/19
 **/
public class IdUtil {

	/**
	 * 生成不带"-"的UUID
	 *
	 * @return UUID
	 */
	public static String simpleUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
