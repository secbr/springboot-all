package com.secbro2.strategy;

/**
 * 环境角色类
 **/
public class DistanceContext {

	/**
	 * 持有策略抽象类
	 */
	private AbstractParkStrategy abstractParkStrategy;

	// 通过构造方法注入，也可以通过其他方式注入
	public DistanceContext(AbstractParkStrategy parkStrategy) {
		this.abstractParkStrategy = parkStrategy;
	}

	public int calcDistance(int count) {
		return abstractParkStrategy.calcDistance(count);
	}

}
