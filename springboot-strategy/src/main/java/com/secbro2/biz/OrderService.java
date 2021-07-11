package com.secbro2.biz;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author sec
 * @version 1.0
 * @date 2021/5/31
 **/
@Service
public class OrderService {

	public OrderService(){
		System.out.println("OrderService构造方法被执行...");
	}

	@PostConstruct
	private void init() {
		System.out.println("PostConstruct注解方法被调用");
	}

	@PostConstruct
	private void init1() {
		System.out.println("PostConstruct init1 注解方法被调用");
	}

	@PreDestroy
	private void shutdown() {
		System.out.println("PreDestroy注解方法被调用");
	}

}
