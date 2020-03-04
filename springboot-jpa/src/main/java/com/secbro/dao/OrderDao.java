package com.secbro.dao;

import com.secbro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/2 7:42 PM
 **/
public interface OrderDao extends JpaRepository<Order,Integer> {

	int countByAmount(int amount);

	List<Order> findByOrderNo(String orderNo);

	List<Order> findByAmount(int amount);
}
