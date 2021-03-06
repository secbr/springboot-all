package com.secbro.dao.db2;

import com.secbro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/2 7:42 PM
 **/
public interface OrderDb2Dao extends JpaRepository<Order, Integer> {

	int countByAmount(int amount);

	List<Order> findByOrderNo(String orderNo);

	List<Order> findByAmount(int amount);

	/**
	 * 根据OrderNo前缀进行查询
	 *
	 * @param preString No 前缀
	 * @return 返回列表
	 */
	@Query("select o from Order o where orderNo like ?1%")
	List<Order> findByPreNo(String preString);

	@Query(value = "select * from tb_order where order_no like ?1%", nativeQuery = true)
	List<Order> findByPreNoNative(String preString);

	List<Order> findByOrderNoAndAmt(String orderNo, int amount);

	@Transactional
	@Modifying
	@Query("update Order o set o.amount= ?2 where o.id = ?1")
	int modifyAmtById(int id, int amount);
}
