package com.secbro.springboot.eaysexcel.service;

import com.secbro.springboot.eaysexcel.entity.Member;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2022/7/31
 **/
public interface MemberService {

	/**
	 * 获取所有的成员信息
	 * @return 成员信息列表
	 */
	List<Member> getAllMember();

}
