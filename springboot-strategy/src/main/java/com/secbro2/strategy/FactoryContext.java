package com.secbro2.strategy;

/**
 * 环境角色类
 **/
public class FactoryContext {

	/**
	 * 持有策略抽象类
	 */
	private AbstractParkStrategy parkStrategy;

	// 把创建策略放在封装角色内，客户端只需要知道结果
	public void factory(int strategyType) {
		if (strategyType == 1) {
			parkStrategy = new PeopleParkStrategy();
		} else if (strategyType == 2) {
			parkStrategy = new BeiHaiParkStrategy();
		} else {
			parkStrategy = new DefaultParkStrategy();
		}
	}
	
	public int calcDistance(int count) {
		return parkStrategy.calcDistance(count);
	}

}
