package com.secbro2.db;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/26 3:54 PM
 **/
public class OracleDbConfigBean implements DbConfigBean {

	@Override
	public void printInfo(){
		System.out.println("I am Oracle!");
	}
}
