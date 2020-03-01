package com.secbro.service.impl;

import com.secbro.mapper.OrderMapper;
import com.secbro.model.Order;
import com.secbro.model.OrderExample;
import com.secbro.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;

	@Override
	public Order findByOrderNo(String orderNo){
		OrderExample example = new OrderExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		List<Order> list =  orderMapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}


}
