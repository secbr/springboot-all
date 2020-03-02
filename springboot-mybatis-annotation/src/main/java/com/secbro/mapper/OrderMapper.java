package com.secbro.mapper;

import com.secbro.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 10:01 AM
 **/
public interface OrderMapper {

	/**
	 * 创建订单
	 *
	 * @param order 订单信息
	 * @return 记录数
	 */
	@Insert("INSERT INTO tb_order(order_no,amount) VALUES(#{orderNo}, #{amount})")
	int save(Order order);

	/**
	 * 更新订单
	 *
	 * @param order 订单信息
	 * @return 记录数
	 */
	@Update("UPDATE tb_order SET order_no = #{orderNo},amount = #{amount} WHERE id =#{id}")
	int update(Order order);

	/**
	 * 删除
	 *
	 * @param id id
	 * @return 条数
	 */
	@Delete("DELETE FROM tb_order WHERE id =#{id}")
	int delete(int id);

	/**
	 * 根据ID查询
	 *
	 * @param id 订单id
	 * @return 订单详情
	 */
	@Select("SELECT id,order_no as orderNo,amount FROM tb_order WHERE id = #{id}")
	Order findById(int id);

	/**
	 * 查询所有用户
	 *
	 * @return 用户列表
	 */
	@Select("SELECT * FROM tb_order")
	@Results({
			@Result(property = "orderNo", column = "order_no")
	})
	List<Order> findAll();
}
