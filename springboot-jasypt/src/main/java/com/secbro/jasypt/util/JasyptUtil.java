package com.secbro.jasypt.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author sec
 * @version 1.0
 * @date 2021/9/28
 **/
public class JasyptUtil {

	public static void main(String[] args) {
		BasicTextEncryptor se = new BasicTextEncryptor();

		se.setPassword("afx11");
		String postgres = se.encrypt("admin123");
		System.out.println(postgres);
	}
}
