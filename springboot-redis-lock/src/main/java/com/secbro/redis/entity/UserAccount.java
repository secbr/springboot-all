package com.secbro.redis.entity;

/**
 * @author sec
 * @version 1.0
 * @date 2021/10/17
 **/
public class UserAccount {

	//用户ID
	private String userId;
	//账户内金额
	private int amount;

	public UserAccount(String userId, int amount) {
		this.userId = userId;
		this.amount = amount;
	}

	public UserAccount() {
	}

	//添加账户金额
	public void addAmount(int amount) {
		this.amount = this.amount + amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
