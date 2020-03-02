package com.secbro.dao;

import com.secbro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/2 7:42 PM
 **/
public interface OrderDao extends JpaRepository<Order,Integer> {
}
