package com.secbro.service.impl;

import com.secbro.model.Order;
import com.secbro.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Order order) {
		return jdbcTemplate.update("insert into tb_order(order_no, amount) values(?, ?)", order.getOrderNo(),
				order.getAmount());
	}

	@Override
	public int save(Order order, JdbcTemplate secJdbcTemplate) {
		if (secJdbcTemplate != null) {
			return secJdbcTemplate.update("insert into tb_order(order_no, amount) values(?, ?)", order.getOrderNo(),
					order.getAmount());
		} else {
			return jdbcTemplate.update("insert into tb_order(order_no, amount) values(?, ?)", order.getOrderNo(),
					order.getAmount());
		}
	}

	@Override
	public int update(Order order) {
		return jdbcTemplate.update("update tb_order set amount = ? where id = ?", order.getAmount(), order.getId());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from tb_order where id = ?", id);
	}

	@Override
	public Order findById(int id) {
		return jdbcTemplate.queryForObject("select * from tb_order where id = ?", new Object[]{id},
				new BeanPropertyRowMapper<>(Order.class));
	}

	@Override
	public List<Order> findAll() {
		return jdbcTemplate.query("select * from tb_order", new OrderRowMapper());
	}

	@Override
	public List<Order> findAllError() {
		return jdbcTemplate.queryForList("select * from tb_order", Order.class);
	}

	/**
	 * RowMapper 可以将数据中的每一行数据封装成用户定义的类，实现RowMapper接口的mapRow方法
	 */
	class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 对数据的返回处理
			Order order = new Order();
			order.setId(rs.getInt("id"));
			order.setOrderNo(rs.getString("order_no"));
			order.setAmount(rs.getInt("amount"));
			return order;
		}
	}
}
