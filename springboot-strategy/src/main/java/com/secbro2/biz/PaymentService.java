package com.secbro2.biz;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author sec
 * @version 1.0
 * @date 2021/5/31
 **/
@Service
public class PaymentService implements InitializingBean, DisposableBean {

	public PaymentService(){
		System.out.println("PaymentService构造方法被执行...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy方法被调用");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet方法被调用");
	}
}
