package com.secbro2.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化工具类
 *
 * @author sec
 * @version 1.0
 * @date 2020/7/7 5:06 下午
 **/
@Component
public class MessageUtils {

	private static MessageSource messageSource;

	public MessageUtils(MessageSource messageSource) {
		MessageUtils.messageSource = messageSource;
	}

	/**
	 * 获取单个国际化翻译值
	 */
	public static String get(String msgKey) {
		try {
			return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
		} catch (Exception e) {
			return msgKey;
		}
	}

}
