package com.secbro2.service;

import com.secbro2.db.DbConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/26 3:59 PM
 **/
@Service
public class DbService {

	@Autowired
	private DbConfigBean configBean;

	public void getDbInfo(){
		configBean.printInfo();
	}
}
