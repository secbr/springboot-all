package com.secbro2.strategy;

/**
 * 抽象类，此处也可以使用接口，根据具体情况定义
 **/
public abstract class AbstractParkStrategy {

	/**
	 * 计算距离的抽象方法
	 * @param count 节点数
	 * @return 总距离
	 */
	public abstract int calcDistance(int count);
}
